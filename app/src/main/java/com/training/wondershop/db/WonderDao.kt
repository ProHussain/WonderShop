package com.training.wondershop.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.training.wondershop.models.Product

/**
 * WonderDao interface
 * Used to store product data from API and Room
 */

@Dao
interface WonderDao {
    @Insert
    suspend fun addProduct(product: List<Product>)

    @Query("SELECT * FROM product")
    suspend fun getAllProducts(): List<Product>
}