package com.training.wondershop.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.training.wondershop.models.Product
import com.training.wondershop.retrofit.WonderAPI
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val wonderAPI: WonderAPI) {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = wonderAPI.getProducts()
        if (result.isSuccessful && result.body() != null ) {
            _products.postValue(result.body())
        }
    }
}