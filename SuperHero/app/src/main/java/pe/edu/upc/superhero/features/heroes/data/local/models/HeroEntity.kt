package pe.edu.upc.superhero.features.heroes.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val fullName: String,
    val image: String
)
