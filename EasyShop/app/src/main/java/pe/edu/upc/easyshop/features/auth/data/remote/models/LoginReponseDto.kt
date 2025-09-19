package pe.edu.upc.easyshop.features.auth.data.remote.models

data class LoginResponseDto(
    val accessToken: String,
    val email: String,
    val firstName: String,
    val gender: String,
    val id: Int,
    val image: String,
    val lastName: String,
    val refreshToken: String,
    val username: String
)