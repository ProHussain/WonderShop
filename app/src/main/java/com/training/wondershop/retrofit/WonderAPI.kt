package com.training.wondershop.retrofit

import com.training.wondershop.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface WonderAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}