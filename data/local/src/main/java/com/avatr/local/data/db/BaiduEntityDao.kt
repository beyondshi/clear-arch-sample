package com.avatr.local.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.avatr.local.data.entites.BaiduEntity

@Dao
interface BaiduEntityDao {

    @Query("Select * from baidu_content")
    suspend fun getContent(): BaiduEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveContent(content: BaiduEntity)
}