package com.aba.core.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.TypeConverters
import com.aba.core.BuildConfig
import com.aba.core.data.local.converter.ReviewTypeConverter
import com.aba.core.data.model.lawyer.LawyerRanking
import com.aba.core.data.model.lawyer.Review

@Entity(tableName = BuildConfig.LAWYER_TABLE_NAME, primaryKeys = ["id"] )
data class LawyerLocalModel(
    val id: String,
    val firstName: String,
    val surName: String,
    val rate: Double,
    val rating: Double,
    val reviews: List<Review>,
    @Embedded
    val ranking: LawyerRanking,
    val speciality: String,
    val isBackgroundVerified: Boolean,
    val description: String,
    val info: String,
    val averageResponseTime: Int,
    val memberSince: String,
    val isFavorite: Boolean,
    val isFeatured: Boolean
)