package pe.edu.upc.easyshop.features.home.data.remote.models

data class ProductsWrapperDto(
    val limit: Int,
    val products: List<ProductDto>,
    val skip: Int,
    val total: Int
)