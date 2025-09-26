package pe.edu.upc.easyshop.features.auth.presentation.di

import pe.edu.upc.easyshop.features.auth.data.di.DataModule.getAuthRepository
import pe.edu.upc.easyshop.features.auth.presentation.login.LoginViewModel

object PresentationModule {
    fun getLoginViewModel(): LoginViewModel {
        return LoginViewModel(getAuthRepository())
    }
}