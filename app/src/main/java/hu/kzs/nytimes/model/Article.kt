package hu.kzs.nytimes.model

data class Article(
    val id: Long,
    val url: String,
    val byline: String,
    val title: String,
    val publishedDate: String,
    val imageUrl: String?
)