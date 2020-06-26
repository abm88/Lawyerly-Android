package com.aba.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aba.core.factory.AppViewModelFactory
import com.aba.core.ui.listing.ListingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListingViewModel::class)
    abstract fun bindLawyerViewModel(viewModel: ListingViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory : AppViewModelFactory) : ViewModelProvider.Factory

}
