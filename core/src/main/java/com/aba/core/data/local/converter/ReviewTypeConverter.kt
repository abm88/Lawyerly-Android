package com.aba.core.data.local.converter

import androidx.room.TypeConverter
import com.aba.core.data.model.lawyer.Review
import com.google.gson.Gson


class ReviewTypeConverter  {

    @TypeConverter
    fun fromReviewList(reviews: List<Review>): String = Gson().toJson(reviews)

    @TypeConverter
    fun toReviewList(value: String) = Gson().fromJson(value, Array<Review>::class.java).toList()

}