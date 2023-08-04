package com.training.wondershop.models

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Product data class
 * Used to store product data from API and Room
 */

@Entity
data class Product(
    val category: String,
    val description: String,
    @PrimaryKey (autoGenerate = false)
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)