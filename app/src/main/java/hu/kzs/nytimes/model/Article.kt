package hu.kzs.nytimes.model

import com.google.gson.annotations.SerializedName

data class Article(
    val id: Long,
    val url: String,
    val byline: String,
    val title: String,
    @SerializedName("published_date")
    val publishedDate: String,
    val media: List<MediaData>
)