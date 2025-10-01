package pe.edu.upc.easyshop.features.home.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.easyshop.core.database.AppDatabase
import pe.edu.upc.easyshop.features.home.data.local.dao.ProductDao
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {



    @Provides
    @Singleton
    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()

    }
}