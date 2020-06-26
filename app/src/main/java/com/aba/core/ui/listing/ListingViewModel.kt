package com.aba.core.ui.listing

import androidx.lifecycle.MutableLiveData
import com.aba.core.base.BaseViewModel
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.domain.usecase.LawyerUseCase
import com.aba.core.extension.plusAssign
import com.aba.core.network.ResultResponse
import com.aba.core.rx.ResultSubscriber
import javax.inject.Inject

class ListingViewModel @Inject constructor(
    private val lawyerUseCase: LawyerUseCase
) : BaseViewModel() {

    val lawyerLiveData: MutableLiveData<ResultResponse<List<LawyerDomainModel>>>
        get() = _LawyerLiveData
    private val _LawyerLiveData = MutableLiveData<ResultResponse<List<LawyerDomainModel>>>()

    fun getAllLawyers() {
        this += lawyerUseCase.execute(lawyerUseCase.with())
            .subscribeWith(ResultSubscriber(_LawyerLiveData) { liveData ->
                // starts with
                liveData.postValue(ResultResponse.Loading())
            })

    }



}