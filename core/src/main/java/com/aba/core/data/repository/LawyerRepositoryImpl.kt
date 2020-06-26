package com.aba.core.data.repository

import com.aba.core.data.local.datasource.LawyerLocalDataSource
import com.aba.core.data.remote.datasource.RemoteDataSource
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.domain.repository.LawyerRepository
import com.aba.core.network.ResultResponse
import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LawyerRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LawyerLocalDataSource
) : LawyerRepository {
    override fun getAllLawyers(): Observable<ResultResponse<List<LawyerDomainModel>>> =
        Observable.concatArrayEagerDelayError(
            callRemote()
        ).flatMap{
            Observable.just(ResultResponse.Success(it))
        }

    private fun callLocal() = localDataSource.getAllLawyers().delay(2, TimeUnit.SECONDS)

    private fun callRemote() = remoteDataSource.getAllLawyers()
}