package com.aba.core.domain.repository

import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.network.ResultResponse
import io.reactivex.Observable

interface LawyerRepository {
    fun getAllLawyers(): Observable<ResultResponse<List<LawyerDomainModel>>>
}