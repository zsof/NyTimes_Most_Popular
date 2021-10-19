package hu.kzs.nytimes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class RoomArticle(
    @PrimaryKey
    var id: Long,
    val url: String,
    val byline: String,
    val title: String,
    val publishedDate: String,
    val imageUrl: String?
)
