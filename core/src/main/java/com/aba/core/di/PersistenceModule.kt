package com.aba.core.di

import android.content.Context
import com.aba.core.data.local.AppDatabase
import com.aba.core.data.local.dao.LawyerDao
import com.aba.core.di.scope.PerApplication
import dagger.Module
import dagger.Provides

@Module
class PersistenceModule {

    @Provides
    @PerApplication
    fun provideDataBase(context: Context): AppDatabase = AppDatabase.create(context)

    @Provides
    @PerApplication
    fun provideSearchDao(appDataBase: AppDatabase): LawyerDao = appDataBase.provideLawyerDao()
}