package pe.edu.upc.superhero.features.heroes.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.edu.upc.superhero.features.heroes.data.local.models.HeroEntity

@Dao
interface HeroDao {

    @Insert
    suspend fun insert(vararg entity: HeroEntity)

    @Delete
    suspend fun delete(vararg entity: HeroEntity)

    @Query("select * from heroes")
    suspend fun fetchAll(): List<HeroEntity>

    @Query("select * from heroes where id=:id")
    suspend fun fetchById(id: Int): List<HeroEntity>
}