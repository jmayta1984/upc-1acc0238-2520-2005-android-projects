package pe.edu.upc.superhero.features.heroes.domain

data class Hero(
    val id: String,
    val name: String,
    val fullName: String,
    val image: String,
    var isFavorite: Boolean = false
)