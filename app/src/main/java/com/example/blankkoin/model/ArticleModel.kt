package com.example.blankkoin.model

data class ArticleModel (
    val id: Long,
    val url: String,
    val byline: String,
    val title: String,
    val publishedDate: String,
    val imageUrl: String?
)