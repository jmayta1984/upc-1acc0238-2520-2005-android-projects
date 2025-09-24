package pe.edu.upc.easyshop.features.home.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("products")
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val price: Double
)
