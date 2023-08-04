package com.training.wondershop.di

import androidx.lifecycle.ViewModel
import com.training.wondershop.viewmodel.HomeViewModel
import com.training.wondershop.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * ViewModelModule is a class that is responsible for providing ViewModels
 * We need to annotate it with @Module and @Binds
 * @Module tells Dagger that this class is a Dagger Module
 * @Binds tells Dagger that the method inside this class is used for binding
 * We need to create a method for each ViewModel
 * Now we have two methods that are returning ViewModels and create a confusion for Dagger
 * So we need to tell Dagger which method is for which ViewModel
 * We can do that by adding @IntoMap and @ClassKey annotations to the methods
 * @IntoMap tells Dagger that the method is used for adding the object returned by the method to a map
 * @ClassKey tells Dagger that the method is used for creating a key for the map
 */

@Module
abstract class ViewModelModule {
    @Binds
    @ClassKey(MainViewModel::class)
    @IntoMap
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @ClassKey(HomeViewModel::class)
    @IntoMap
    abstract fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}