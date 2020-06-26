package com.aba.core.ui.details.di

import com.aba.core.di.scope.PerFragment
import com.aba.core.ui.details.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailFragmentBinding {
    @PerFragment
    @ContributesAndroidInjector()
    abstract fun contributeSearchFragment(): DetailFragment
}