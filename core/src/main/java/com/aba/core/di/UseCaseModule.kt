package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.di.scope.PerApplication
import com.aba.core.domain.repository.LawyerRepository
import com.aba.core.domain.usecase.LawyerUseCase
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    @PerApplication
    fun provideLawyerUseCase(
        @NonNull repository: LawyerRepository,
        @NonNull schedulerProvider: SchedulerProvider,
        @NonNull errorContainer: ErrorContainer
    ): LawyerUseCase =
        LawyerUseCase(
            repository,
            schedulerProvider,
            errorContainer
        )
}