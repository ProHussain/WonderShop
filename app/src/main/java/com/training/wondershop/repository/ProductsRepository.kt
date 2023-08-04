package com.training.wondershop.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.training.wondershop.db.WonderDatabase
import com.training.wondershop.models.Product
import com.training.wondershop.retrofit.WonderAPI
import javax.inject.Inject

/**
 * ProductsRepository is a class that is responsible for fetching data from the API and ROOM
 * and providing it to the ViewModel
 * @param wonderAPI is the API interface that is used to make the network calls
 * @param database is the WonderDatabase that is used to store the data in ROOM
 * @property _products is the MutableLiveData that is used to store the list of products
 * @property products is the LiveData that is used to expose the list of products to the ViewModel
 * @constructor creates a new instance of the ProductsRepository class
 * @Inject tells Dagger how to create instances of this type
 */

class ProductsRepository @Inject constructor(private val wonderAPI: WonderAPI, private val database: WonderDatabase) {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = wonderAPI.getProducts()
        if (result.isSuccessful && result.body() != null ) {
            database.wonderDao().addProduct(result.body()!!)
            _products.postValue(result.body())
        }
    }
}