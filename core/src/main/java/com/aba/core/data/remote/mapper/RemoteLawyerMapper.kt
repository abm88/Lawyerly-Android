package com.aba.core.data.remote.mapper

import com.aba.core.base.RemoteMapper
import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.domain.data.LawyerDomainModel

class RemoteLawyerMapper: RemoteMapper<List<LawyerDTO>, List<LawyerDomainModel>> {
    override fun map(items: List<LawyerDTO>): List<LawyerDomainModel> =
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