package com.aba.core.data.local.dao

import androidx.room.*
import com.aba.core.BuildConfig
import com.aba.core.data.local.model.LawyerLocalModel
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface LawyerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(items: List<LawyerLocalModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(item: LawyerLocalModel)

    @Query("select * from ${BuildConfig.LAWYER_TABLE_NAME}")
    fun getAllLawyers(): Observable<List<LawyerLocalModel>>

    @Query("select * from ${BuildConfig.LAWYER_TABLE_NAME} WHERE isFavorite = 1")
    fun getFavoriteLawyers(): Observable<List<LawyerLocalModel>>

    @Query("select * from ${BuildConfig.LAWYER_TABLE_NAME} where isFeatured = 1")
    fun getFeaturedLawyers(): Observable<List<LawyerLocalModel>>

}