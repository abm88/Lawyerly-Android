package com.aba.core.data.local.mapper

import com.aba.core.base.LocalMapper
import com.aba.core.data.local.model.LawyerLocalModel
import com.aba.core.domain.data.LawyerDomainModel

class LawyerLocalMapper : LocalMapper<List<LawyerLocalModel>, List<LawyerDomainModel>> {

    override fun mapToLocal(items: List<LawyerDomainModel>): List<LawyerLocalModel> =
        mutableListOf<LawyerLocalModel>().also { output ->
            with(items) {
                forEach {
                    output.add(
                        LawyerLocalModel(
                            id = it.id,
                            firstName = it.firstName,
                            surName = it.surName,
                            rate = it.rate,
                            rating = it.rating,
                            reviews = it.reviews,
                            ranking = it.ranking,
                            speciality = it.speciality,
                            isBackgroundVerified = it.isBackgroundVerified,
                            description = it.description,
                            info = it.info,
                            averageResponseTime = it.averageResponseTime,
                            memberSince = it.memberSince,
                            isFeatured = it.isFeatured,
                            isFavorite = it.isFavorite
                        )
                    )
                }
            }
        }


    override fun mapFromLocal(items: List<LawyerLocalModel>): List<LawyerDomainModel> =
        mutableListOf<LawyerDomainModel>().also { output ->
            with(items) {
                forEach {
                    output.add(
                        LawyerDomainModel(
                            id = it.id,
                            firstName = it.firstName,
                            surName = it.surName,
                            rate = it.rate,
                            rating = it.rating,
                            reviews = it.reviews,
                            ranking = it.ranking,
                            speciality = it.speciality,
                            isBackgroundVerified = it.isBackgroundVerified,
                            description = it.description,
                            info = it.info,
                            averageResponseTime = it.averageResponseTime,
                            memberSince = it.memberSince,
                            isFeatured = it.isFeatured,
                            isFavorite = it.isFavorite
                        )
                    )
                }
            }

        }

}