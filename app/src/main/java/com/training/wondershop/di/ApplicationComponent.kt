package com.training.wondershop.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.training.wondershop.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * ApplicationComponent is the main component of the application.
 * We can access it on Application class and inject it to the activity.
 * @Singleton annotation is used to make sure that the instance of this component is singleton.
 * @Component annotation is used to make sure that this interface is a component.
 * inject() function is used to inject the dependencies to the activity.
 * getMap() function is used to get the map of ViewModels.
 */

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}