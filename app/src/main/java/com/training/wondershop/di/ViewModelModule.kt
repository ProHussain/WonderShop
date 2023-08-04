package com.training.wondershop.di

import androidx.lifecycle.ViewModel
import com.training.wondershop.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel
}