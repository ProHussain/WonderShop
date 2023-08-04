package com.training.wondershop.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * HomeViewModel is a class that we used for practice purpose
 * It is a part of the MVVM architecture and it is a lifecycle-aware component
 * We used it to create a generic ViewModelProvider.Factory
 */

class HomeViewModel @Inject constructor() : ViewModel() {
    fun writeSomething() {
        Log.i("HomeViewModel", "writeSomething: ")
    }
}