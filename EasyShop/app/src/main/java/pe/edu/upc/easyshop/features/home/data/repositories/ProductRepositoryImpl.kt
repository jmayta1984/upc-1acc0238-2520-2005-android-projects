package pe.edu.upc.easyshop.features.home.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyshop.features.home.data.remote.services.ProductService
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.models.Product

class ProductRepositoryImpl(private val productService: ProductService) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> = withContext(Dispatchers.IO) {
        val response = productService.getAllProducts()

        if (response.isSuccessful) {
            response.body()?.let { productsWrapperDto ->
                val products = productsWrapperDto.products.map { productDto ->
                    Product(
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

}