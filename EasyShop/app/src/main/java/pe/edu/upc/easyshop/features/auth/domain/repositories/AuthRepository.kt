package pe.edu.upc.easyshop.features.auth.domain.repositories

import pe.edu.upc.easyshop.features.auth.domain.models.User

interface AuthRepository {
    suspend fun login(username: String, password: String): User?
}