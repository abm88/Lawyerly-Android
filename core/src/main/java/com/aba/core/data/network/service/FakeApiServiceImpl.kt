package com.aba.core.data.network.service

import com.aba.core.data.helper.DataGenerator
import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.data.model.lawyer.LawyerRanking
import com.aba.core.data.model.lawyer.Review
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Intended to simulate a network API service class.
 */
class FakeApiServiceImpl @Inject constructor() : FakeApiService {

    override fun getFeaturedLawyers(): Observable<List<LawyerDTO>> =
        Observable.just(DataGenerator.featuredLawyer)

    override fun getAllLawyers(): Observable<List<LawyerDTO>> = Observable.just(DataGenerator.allLawyers)

    override fun getFavoriteLawyers(): Observable<List<LawyerDTO>> = Observable.just(DataGenerator.favoriteLawyers)


}