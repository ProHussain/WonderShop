package com.training.wondershop

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.training.wondershop.adapter.MainAdapter
import com.training.wondershop.models.Product
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

    lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val mainRv: RecyclerView
        get() = findViewById(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as WonderApplication).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        mainRv.adapter = MainAdapter()
        mainViewModel.productsLiveData.observe(this) {
            (mainRv.adapter as MainAdapter).setProducts(it)
        }
    }
}