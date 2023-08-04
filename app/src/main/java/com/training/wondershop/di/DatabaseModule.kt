package com.training.wondershop.di

import android.content.Context
import androidx.room.Room
import com.training.wondershop.db.WonderDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context:Context) : WonderDatabase {
        return Room.databaseBuilder(context, WonderDatabase::class.java, "wonder_db")
            .build()
    }
}