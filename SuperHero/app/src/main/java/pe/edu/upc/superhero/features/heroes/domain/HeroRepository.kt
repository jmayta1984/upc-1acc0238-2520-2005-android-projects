package pe.edu.upc.superhero.features.heroes.domain

interface HeroRepository {

    suspend fun searchHero(query: String): List<Hero>
}