package com.aba.core.data.model.lawyer

import android.os.Parcel
import android.os.Parcelable

data class LawyerRanking(
    val ranking: Int,
    val numberOfCandidates: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(ranking)
        parcel.writeInt(numberOfCandidates)
    }

    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<LawyerRanking> {
        override fun createFromParcel(parcel: Parcel): LawyerRanking {
            return LawyerRanking(parcel)
        }

        override fun newArray(size: Int): Array<LawyerRanking?> {
            return arrayOfNulls(size)
        }
    }
}