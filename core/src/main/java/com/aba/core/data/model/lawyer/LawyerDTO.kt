package com.aba.core.data.model.lawyer

data class LawyerDTO(
    val id: String,
    val firstName: String,
    val surName: String,
    val rate: Double,
    val rating: Double,
    val reviews: List<Review>,
    val ranking: LawyerRanking,
    val speciality: String,
    val isBackgroundVerified: Boolean,
    val description: String,
    val info: String,
    val averageResponseTime: Int,
    val memberSince: String,
    val isFeatured: Boolean,
    val isFavorite: Boolean
)