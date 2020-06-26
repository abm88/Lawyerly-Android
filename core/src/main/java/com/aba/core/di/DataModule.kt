package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.base.LocalMapper
import com.aba.core.base.RemoteMapper
import com.aba.core.data.local.datasource.LawyerListLocalDataSourceImpl
import com.aba.core.data.local.datasource.LawyerListLocalDataSourceImpl_Factory
import com.aba.core.data.local.datasource.LawyerLocalDataSource
import com.aba.core.data.local.mapper.LawyerLocalMapper
import com.aba.core.data.local.model.LawyerLocalModel
import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.data.remote.datasource.RemoteDataSource
import com.aba.core.data.remote.datasource.RemoteDataSourceImpl
import com.aba.core.data.remote.mapper.RemoteLawyerMapper
import com.aba.core.data.repository.LawyerRepositoryImpl
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.domain.repository.LawyerRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
abstract class DataModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideRemoteMapper(): RemoteMapper<List<LawyerDTO>, List<LawyerDomainModel>>
                = RemoteLawyerMapper()

        @JvmStatic
        @Provides
        fun provideLocalMapper(): LocalMapper<List<LawyerLocalModel>, List<LawyerDomainModel>> = LawyerLocalMapper()
    }

    @Binds
    abstract fun provideRepository(
        @NonNull repository: LawyerRepositoryImpl
    ): LawyerRepository


    @Binds
    abstract fun provideRemoteDataSource(
        remoteDataSource: RemoteDataSourceImpl
    ): RemoteDataSource


    @Binds
    abstract fun provideLocalDataSource(
        localDataSource: LawyerListLocalDataSourceImpl
    ): LawyerLocalDataSource

}