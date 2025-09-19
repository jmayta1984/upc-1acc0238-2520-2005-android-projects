package pe.edu.upc.easyshop.features.auth.domain.models

data class User(
    val username: String,
    val token: String,
    val image: String
)
