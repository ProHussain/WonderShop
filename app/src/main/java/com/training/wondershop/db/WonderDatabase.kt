package com.training.wondershop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.training.wondershop.models.Product

/**
 * WonderDatabase is the database class for the application
 * It extends RoomDatabase
 * It is annotated with @Database and it has a list of entities and a version number
 * The entities is the list of entities that we want to store in the database
 */

@Database(entities = [Product::class], version = 1)
abstract class WonderDatabase : RoomDatabase() {
    abstract fun wonderDao(): WonderDao
}