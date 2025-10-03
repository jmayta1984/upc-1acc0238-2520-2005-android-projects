package pe.edu.upc.superhero.features.heroes.data.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.superhero.features.heroes.data.local.dao.HeroDao
import pe.edu.upc.superhero.features.heroes.data.remote.service.HeroService
import pe.edu.upc.superhero.features.heroes.domain.Hero
import pe.edu.upc.superhero.features.heroes.domain.HeroRepository
import javax.inject.Inject

class HeroRepositoryImpl @Inject constructor(
    private val service: HeroService,
    private val dao: HeroDao
) : HeroRepository {
    override suspend fun searchHero(query: String): List<Hero> = withContext(Dispatchers.IO) {

        val response = service.searchHero(query = query)

        if (response.isSuccessful) {
            response.body()?.let { wrapperDto ->
                return@withContext wrapperDto.heroesDto.map { heroDto ->
                    Hero(
                        id = heroDto.id,
                        name = heroDto.name,
                        fullName = heroDto.biography.fullName,
                        image = heroDto.image.url
                    )
                }
            }
        }

        return@withContext emptyList()
    }
}