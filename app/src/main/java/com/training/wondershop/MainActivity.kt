package com.training.wondershop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.training.wondershop.viewmodel.MainViewModel
import com.training.wondershop.viewmodel.MainViewModelFactory
import javax.inject.Inject

/**
 * Welcome to WonderShop!
 * In this project, you will be creating a shopping app for a local store with a Fake Store API.
 * We will be using Retrofit, GSON, Dagger, Room and Coroutines to build this app.
 * We will also be using the MVVM architecture to build this app.
 */

class MainActivity : AppCompatActivity() {

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

        mainViewModel.productsLiveData.observe(this) {
            text.text = it.joinToString { product -> product.title }
        }
    }
}