package com.training.wondershop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.training.wondershop.viewmodel.HomeViewModel
import com.training.wondershop.viewmodel.MainViewModel
import com.training.wondershop.viewmodel.MainViewModelFactory
import javax.inject.Inject

/**
 * Welcome to WonderShop!
 * In this project, you will be creating a shopping app for a local store with a Fake Store API.
 * We will be using Retrofit, GSON, Dagger, Room and Coroutines to build this app.
 * We will also be using the MVVM architecture to build this app.
 * How our MainActivity works:
 * 1. We inject our MainViewModelFactory into our MainActivity
 * 2. We use the MainViewModelFactory to create our MainViewModel
 * 3. We observe the LiveData from our MainViewModel
 * 4. We display the products from our LiveData in our TextView
 */

class MainActivity : AppCompatActivity() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val text: TextView
        get() = findViewById(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as WonderApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        mainViewModel.productsLiveData.observe(this) {
            text.text = it.joinToString { product -> product.title }
        }
        homeViewModel.writeSomething()
    }
}