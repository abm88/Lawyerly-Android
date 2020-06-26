package com.aba.core.di

import com.aba.core.data.network.service.FakeApiService
import com.aba.core.data.network.service.FakeApiServiceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideAPI(): FakeApiService = FakeApiServiceImpl()

}