package pe.edu.upc.superhero.features.heroes.data.remote.service

import pe.edu.upc.superhero.features.heroes.data.remote.models.HeroesWrapperDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroService {

    @GET("{apiKey}/search/{query}")
    suspend fun searchHero(
        @Path("apiKey") apikey: String = "f274286a22873ec9fc7a5782940f7ca2",
        @Path("query") query: String
    ): Response<HeroesWrapperDto>
}