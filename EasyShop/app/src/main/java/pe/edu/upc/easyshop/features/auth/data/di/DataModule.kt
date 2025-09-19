package pe.edu.upc.easyshop.features.auth.data.di

import pe.edu.upc.easyshop.core.networking.ApiConstants
import pe.edu.upc.easyshop.features.auth.data.remote.services.AuthService
import pe.edu.upc.easyshop.features.auth.data.repositories.AuthRepositoryImpl
import pe.edu.upc.easyshop.features.auth.domain.repositories.AuthRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getAuthRepository(): AuthRepository {
        return AuthRepositoryImpl(getAuthService())
    }

    fun getAuthService(): AuthService {
        return getRetrofit().create(AuthService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}