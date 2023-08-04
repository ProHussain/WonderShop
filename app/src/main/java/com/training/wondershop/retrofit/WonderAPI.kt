package com.training.wondershop.retrofit

import com.training.wondershop.models.Product
import retrofit2.Response
import retrofit2.http.GET

/**
 * WonderAPI is an interface that defines the possible HTTP operations.
 * It is used to send HTTP request to the server.
 */

interface WonderAPI {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}