package pe.edu.upc.superhero.features.heroes.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.edu.upc.superhero.features.heroes.data.local.dao.HeroDao
import pe.edu.upc.superhero.features.heroes.data.local.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "superhero"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHeroDao(appDatabase: AppDatabase) : HeroDao {
        return  appDatabase.heroDao()
    }
}