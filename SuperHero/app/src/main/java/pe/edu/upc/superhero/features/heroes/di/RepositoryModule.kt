package pe.edu.upc.superhero.features.heroes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.superhero.features.heroes.data.repositories.HeroRepositoryImpl
import pe.edu.upc.superhero.features.heroes.domain.HeroRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun provideHeroRepository(impl: HeroRepositoryImpl): HeroRepository
}