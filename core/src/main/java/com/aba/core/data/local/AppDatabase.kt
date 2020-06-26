package com.aba.core.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aba.core.BuildConfig
import com.aba.core.data.local.converter.ReviewTypeConverter
import com.aba.core.data.local.dao.LawyerDao
import com.aba.core.data.local.model.LawyerLocalModel

@Database(
    entities = [
        (LawyerLocalModel::class)
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(ReviewTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {

    companion object {
        fun create(context: Context): AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                BuildConfig.DB_NAME
            ).allowMainThreadQueries().build()

        fun getTestInstance(context: Context) =
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }
    abstract fun provideLawyerDao(): LawyerDao
}