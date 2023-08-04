package com.training.wondershop.di

import android.content.Context
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
 */

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}