package pe.edu.upc.easyshop.features.home.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyshop.features.home.data.local.dao.ProductDao
import pe.edu.upc.easyshop.features.home.data.local.models.ProductEntity
import pe.edu.upc.easyshop.features.home.data.remote.services.ProductService
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.models.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor (
    private val productService: ProductService,
    private val productDao: ProductDao
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> = withContext(Dispatchers.IO) {
        val response = productService.getAllProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsWrapperDto ->
                val products = productsWrapperDto.products.map { productDto ->
                    Product(
                        id = productDto.id,
                        name = productDto.title,
                        price = productDto.price,
                        image = productDto.thumbnail
                    )
                }
                return@withContext products
            }
        }

        return@withContext emptyList()
    }

    override suspend fun getProductById(id: Int): Product? = withContext(Dispatchers.IO) {
        val response = productService.getProductById(id)

        if (response.isSuccessful) {
            response.body()?.let { productDto ->
                val isFavorite  = productDao.fetchProductById(id).isNotEmpty()
                return@withContext Product(
                    id = productDto.id,
                    name = productDto.title,
                    price = productDto.price,
                    image = productDto.thumbnail,
                    isFavorite = isFavorite
                )
            }
        }

        return@withContext null
    }

    override suspend fun saveProduct(product: Product) = withContext(Dispatchers.IO) {
        productDao.insert(
            ProductEntity(
                id = product.id,
                name = product.name,
                price = product.price,
                image =  product.image
            )
        )
    }

    override suspend fun deleteProduct(product: Product) = withContext(Dispatchers.IO){
        productDao.delete(
            ProductEntity(
                id = product.id,
                name = product.name,
                price = product.price,
                image =  product.image
            )
        )
    }

}