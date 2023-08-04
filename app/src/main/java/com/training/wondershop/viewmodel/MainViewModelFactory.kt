package com.training.wondershop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.training.wondershop.repository.ProductsRepository
import javax.inject.Inject

/**
 * Factory for MainViewModel
 * We need to pass the repository to the ViewModel
 * We can't pass the repository directly to the ViewModel because it doesn't know about the repository
 * So we need to create a factory that will create the ViewModel and pass the repository to it
 * @Inject tells Dagger how to create instances of MainViewModelFactory when it is needed
 */

class MainViewModelFactory @Inject constructor(private val mainViewModel: MainViewModel) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return mainViewModel as T
    }
}