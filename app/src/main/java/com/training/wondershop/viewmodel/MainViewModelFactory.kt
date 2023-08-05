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
 * Now there is an issue, We need to create a ViewModelProvider.Factory for every ViewModel
 * it is not a good practice to create a ViewModelProvider.Factory for every ViewModel
 * So we will create a generic ViewModelProvider.Factory
 * Let's learn how to do that
 * We will retrieve the ViewModel from the map that we get from the ApplicationComponent interface
 * Use @JvmSuppressWildcards annotation to suppress the wildcard type error that we get from the map
 */

class MainViewModelFactory @Inject constructor(private val map: Map<Class<*>,@JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  map[modelClass] as T
    }
}