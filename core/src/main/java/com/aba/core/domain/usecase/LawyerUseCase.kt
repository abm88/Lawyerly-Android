package com.aba.core.domain.usecase

import com.aba.core.base.BaseUseCase
import com.aba.core.base.ObservableUseCase
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.domain.repository.LawyerRepository
import com.aba.core.domain.usecase.LawyerUseCase.LawyerParams
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.rx.SchedulerProvider
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LawyerUseCase @Inject constructor(
    private val repository: LawyerRepository,
    schedulerProvider: SchedulerProvider,
    errorContainer: ErrorContainer
) :
    ObservableUseCase<LawyerParams, List<LawyerDomainModel>>(
        schedulerProvider, errorContainer
    ) {

    override fun buildObservable(params: LawyerParams): Observable<ResultResponse<List<LawyerDomainModel>>> =
        repository.getAllLawyers().debounce(350, TimeUnit.MILLISECONDS)

    fun with() = LawyerParams()

    class LawyerParams : BaseUseCase.Params


}