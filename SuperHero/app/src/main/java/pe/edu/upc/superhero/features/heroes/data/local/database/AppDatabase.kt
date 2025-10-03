package pe.edu.upc.superhero.features.heroes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upc.superhero.features.heroes.data.local.dao.HeroDao
import pe.edu.upc.superhero.features.heroes.data.local.models.HeroEntity

@Database(entities = [HeroEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
}