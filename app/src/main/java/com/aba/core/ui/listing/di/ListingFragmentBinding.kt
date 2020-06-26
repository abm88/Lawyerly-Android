package com.aba.core.ui.listing.di

import com.aba.core.di.scope.PerFragment
import com.aba.core.ui.listing.LawyerListingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListingFragmentBinding {
    @PerFragment
    @ContributesAndroidInjector(modules = [SearchFragmentModule::class])
    abstract fun contributeSearchFragment(): LawyerListingFragment
}