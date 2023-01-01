package com.avatr.local.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.avatr.local.data.entites.BaiduEntity

@Database(entities = [BaiduEntity::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun getBaiduDao(): BaiduEntityDao

    companion object {

        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context): LocalDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, LocalDatabase::class.java, "LocalDatabase.db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                //做一些数据库初始化动作
            }
        }).build()
    }
}