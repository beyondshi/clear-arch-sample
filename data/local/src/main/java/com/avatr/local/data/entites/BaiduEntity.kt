package com.avatr.local.data.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "baidu_content")
data class BaiduEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @NotNull val content: String = "",
)