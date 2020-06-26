package com.aba.core.domain.data

import android.os.Parcel
import android.os.Parcelable
import com.aba.core.data.model.lawyer.LawyerRanking
import com.aba.core.data.model.lawyer.Review

data class LawyerDomainModel(
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
    val isFavorite: Boolean,
    val isFeatured: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.createTypedArrayList(Review) ?: listOf(),
        parcel.readParcelable(LawyerRanking::class.java.classLoader) ?: LawyerRanking(0, 0),
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(firstName)
        parcel.writeString(surName)
        parcel.writeDouble(rate)
        parcel.writeDouble(rating)
        parcel.writeTypedList(reviews)
        parcel.writeParcelable(ranking, flags)
        parcel.writeString(speciality)
        parcel.writeByte(if (isBackgroundVerified) 1 else 0)
        parcel.writeString(description)
        parcel.writeString(info)
        parcel.writeInt(averageResponseTime)
        parcel.writeString(memberSince)
        parcel.writeByte(if (isFavorite) 1 else 0)
        parcel.writeByte(if (isFeatured) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LawyerDomainModel> {
        override fun createFromParcel(parcel: Parcel): LawyerDomainModel {
            return LawyerDomainModel(parcel)
        }

        override fun newArray(size: Int): Array<LawyerDomainModel?> {
            return arrayOfNulls(size)
        }
    }
}
