package com.aba.core.data.local.datasource

import com.aba.core.domain.data.LawyerDomainModel
import io.reactivex.Observable
import io.reactivex.Single

interface LawyerLocalDataSource {

    fun getAllLawyers(): Observable<List<LawyerDomainModel>>
    fun getFeaturedLawyers(): Observable<List<LawyerDomainModel>>
    fun getFavoriteLawyers(): Observable<List<LawyerDomainModel>>

}