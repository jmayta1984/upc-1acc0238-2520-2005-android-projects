package pe.edu.upc.easyshop.features.home.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import pe.edu.upc.easyshop.features.home.data.local.models.ProductEntity

interface ProductDao {

    @Insert
    suspend fun insert(vararg entity: ProductEntity)

    @Delete
    suspend fun delete(vararg entity: ProductEntity)

    @Update
    suspend fun update(vararg entity: ProductEntity)

    @Query("select * from products")
    suspend fun fetchAllProducts(): List<ProductEntity>

}