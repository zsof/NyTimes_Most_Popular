package com.example.blankkoin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticleItem(
    @PrimaryKey
    var id: Long,
    val url: String,
    val byline: String,
    val title: String,
    val publishedDate: String,
    val imageUrl: String?
)
