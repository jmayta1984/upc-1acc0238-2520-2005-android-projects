package pe.edu.upc.superhero.features.heroes.data.remote.models

import com.google.gson.annotations.SerializedName

data class HeroDto(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: HeroImage,
    val name: String,
    @SerializedName("powerstats")
    val powerStats: PowerStats,
    val work: Work
)