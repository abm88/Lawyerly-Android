package com.aba.core.data.network.service

import com.aba.core.data.model.lawyer.LawyerDTO
import io.reactivex.Observable
import io.reactivex.Single

interface FakeApiService {

    fun getFeaturedLawyers(): Observable<List<LawyerDTO>>
    fun getAllLawyers(): Observable<List<LawyerDTO>>
    fun getFavoriteLawyers(): Observable<List<LawyerDTO>>

}