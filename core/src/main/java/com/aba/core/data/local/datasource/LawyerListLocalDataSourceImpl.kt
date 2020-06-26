package com.aba.core.data.local.datasource

import com.aba.core.base.LocalMapper
import com.aba.core.data.local.dao.LawyerDao
import com.aba.core.data.local.model.LawyerLocalModel
import com.aba.core.domain.data.LawyerDomainModel
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class LawyerListLocalDataSourceImpl @Inject constructor(
    private val lawyerDao: LawyerDao,
    private val mapper: LocalMapper<List<LawyerLocalModel>, List<LawyerDomainModel>>
) : LawyerLocalDataSource {

    override fun getAllLawyers(): Observable<List<LawyerDomainModel>> = lawyerDao.getAllLawyers().map {
        mapper.mapFromLocal(it)
    }

    override fun getFeaturedLawyers(): Observable<List<LawyerDomainModel>> =
        lawyerDao.getFeaturedLawyers().map {
            mapper.mapFromLocal(it)
        }

    override fun getFavoriteLawyers(): Observable<List<LawyerDomainModel>> =
        lawyerDao.getFavoriteLawyers().map {
            mapper.mapFromLocal(it)
        }
}