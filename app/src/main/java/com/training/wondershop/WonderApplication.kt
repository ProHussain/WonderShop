package com.training.wondershop

import android.app.Application
import com.training.wondershop.di.ApplicationComponent
import com.training.wondershop.di.DaggerApplicationComponent

class WonderApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}