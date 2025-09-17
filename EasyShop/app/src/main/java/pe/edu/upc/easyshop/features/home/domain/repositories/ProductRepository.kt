package pe.edu.upc.easyshop.features.home.domain.repositories

import pe.edu.upc.easyshop.shared.models.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>

}