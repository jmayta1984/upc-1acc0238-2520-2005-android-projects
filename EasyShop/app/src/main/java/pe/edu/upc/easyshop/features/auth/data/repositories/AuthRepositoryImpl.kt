package pe.edu.upc.easyshop.features.auth.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easyshop.features.auth.data.remote.models.LoginRequestDto
import pe.edu.upc.easyshop.features.auth.data.remote.services.AuthService
import pe.edu.upc.easyshop.features.auth.domain.models.User
import pe.edu.upc.easyshop.features.auth.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val service: AuthService) : AuthRepository {
    override suspend fun login(
        username: String,
        password: String
    ): User? = withContext(Dispatchers.IO) {

        val response = service.login(LoginRequestDto(username, password))

        if (response.isSuccessful) {
            response.body()?.let { loginResponseDto ->
                return@withContext User(
                    username = loginResponseDto.username,
                    token = loginResponseDto.accessToken,
                    image = loginResponseDto.image
                )
            }
        }

        return@withContext null
    }
}