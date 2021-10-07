package com.example.blankkoin.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class Article(
    val id: Long,
    val url: String,
    val byline: String,
    val title: String,
    @SerializedName("published_date") val publishedDate: String,
    //@Json(name="published_date") val publishedDate: String
   // val mediaData: List<MediaData>
)