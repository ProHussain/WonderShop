package com.training.wondershop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.wondershop.models.Product
import com.training.wondershop.repository.ProductsRepository
import kotlinx.coroutines.launch

/**
 * MainViewModel is a class that is responsible for preparing and managing the data for an Activity.
 * It also handles the communication of the Activity with the rest of the application
 * (e.g. calling the business logic classes).
 * It is a part of the MVVM architecture.
 * It is a lifecycle-aware component.
 * It is used to store and manage UI-related data in a lifecycle conscious way.
 * It allows data to survive configuration changes such as screen rotations.
 */

class MainViewModel(private val repository: ProductsRepository) : ViewModel() {
    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}