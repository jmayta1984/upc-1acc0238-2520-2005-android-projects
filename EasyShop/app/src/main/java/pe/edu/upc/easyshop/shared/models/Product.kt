package pe.edu.upc.easyshop.shared.models

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val image: String,
    var isFavorite: Boolean = false
)
