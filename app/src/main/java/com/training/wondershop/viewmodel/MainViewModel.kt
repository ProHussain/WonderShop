package com.training.wondershop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.wondershop.models.Product
import com.training.wondershop.repository.ProductsRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductsRepository) : ViewModel() {
    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}