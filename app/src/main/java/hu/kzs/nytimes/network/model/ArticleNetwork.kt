package hu.kzs.nytimes.network.model

import com.google.gson.annotations.SerializedName

data class ArticleNetwork(
    val id: Long,
    val url: String,
    val byline: String,
    val title: String,
    @SerializedName("published_date")
    val publishedDate: String,
    val media: List<MediaData>
)