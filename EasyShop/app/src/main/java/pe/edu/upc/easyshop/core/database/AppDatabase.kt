package pe.edu.upc.easyshop.core.database

import androidx.room.Database
import pe.edu.upc.easyshop.features.home.data.local.dao.ProductDao
import pe.edu.upc.easyshop.features.home.data.local.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase {
    abstract fun getProductDao(): ProductDao
}