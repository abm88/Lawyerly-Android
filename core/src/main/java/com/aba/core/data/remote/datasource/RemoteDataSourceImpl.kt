package com.aba.core.data.remote.datasource

import com.aba.core.base.RemoteMapper
import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.data.network.service.FakeApiService
import com.aba.core.domain.data.LawyerDomainModel
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: FakeApiService,
    private val mapper: RemoteMapper<List<LawyerDTO>, List<LawyerDomainModel>>
) : RemoteDataSource {

    override fun getFeaturedLawyers(): Observable<List<LawyerDomainModel>> = service.getFeaturedLawyers().map {
        mapper.map(it)
    }

    override fun getAllLawyers(): Observable<List<LawyerDomainModel>> = service.getAllLawyers().map {
        mapper.map(it)
    }

    override fun getFavoriteLawyers(): Observable<List<LawyerDomainModel>> = service.getFavoriteLawyers().map {
        mapper.map(it)
    }
}