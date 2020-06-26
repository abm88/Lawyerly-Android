package com.aba.core.data.remote.datasource

import com.aba.core.domain.data.LawyerDomainModel
import io.reactivex.Observable

interface RemoteDataSource {

    fun getFeaturedLawyers(): Observable<List<LawyerDomainModel>>
    fun getAllLawyers(): Observable<List<LawyerDomainModel>>
    fun getFavoriteLawyers(): Observable<List<LawyerDomainModel>>

}