package pe.edu.upc.easyshop.features.home.presentation.di

import pe.edu.upc.easyshop.features.home.data.di.DataModule.getProductRepository
import pe.edu.upc.easyshop.features.home.presentation.viewmodels.HomeViewModel

object PresentationModule {
    fun getHomeViewModel(): HomeViewModel {
        return HomeViewModel(getProductRepository())
    }
}