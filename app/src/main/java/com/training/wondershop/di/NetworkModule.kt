package com.training.wondershop.di

import com.training.wondershop.retrofit.WonderAPI
import com.training.wondershop.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * NetworkModule is a Dagger module responsible for network operations
 * such as providing Retrofit instances and API interfaces.
 */

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideWonderAPI(retrofit: Retrofit): WonderAPI {
        return retrofit.create(WonderAPI::class.java)
    }
}