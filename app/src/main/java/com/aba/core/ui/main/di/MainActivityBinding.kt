package com.aba.core.ui.main.di

import com.aba.core.di.scope.PerActivity
import com.aba.core.ui.main.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class MainActivityBinding {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

}