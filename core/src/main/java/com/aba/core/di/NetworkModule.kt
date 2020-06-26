package com.aba.core.di

import android.content.Context
import androidx.annotation.NonNull
import com.aba.core.BuildConfig
import com.aba.core.network.error.ErrorContainer
import com.aba.core.network.error.GeneralHandlerImpl
import com.aba.core.network.util.ImageLoader
import com.aba.core.network.util.ImageLoaderImpl
import dagger.Module
import dagger.Provides

import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideErrorHandler(errorHandler: GeneralHandlerImpl): ErrorContainer = errorHandler

    @Singleton
    @Provides
    fun provideImageLoader(imageLoader: ImageLoaderImpl): ImageLoader = imageLoader

}