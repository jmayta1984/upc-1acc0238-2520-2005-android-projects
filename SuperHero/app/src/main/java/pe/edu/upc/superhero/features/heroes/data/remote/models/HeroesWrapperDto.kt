package pe.edu.upc.superhero.features.heroes.data.remote.models

import com.google.gson.annotations.SerializedName

data class HeroesWrapperDto(
    val response: String,
    @SerializedName("results")
    val heroesDto: List<HeroDto>,
    @SerializedName("results-for")
    val resultsFor: String
)