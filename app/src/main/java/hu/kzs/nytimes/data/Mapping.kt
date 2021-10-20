package hu.kzs.nytimes.data

import hu.kzs.nytimes.data.model.RoomArticle
import hu.kzs.nytimes.model.Article

fun RoomArticle.toNetworkArticle() = Article(
    id = id,
    url = url,
    byline = byline,
    title = title,
    publishedDate = publishedDate,
    imageUrl = imageUrl
)

fun Article.toDiskArticle() = RoomArticle(
    id = id,
    url = url,
    byline = byline,
    title = title,
    publishedDate = publishedDate,
    imageUrl = imageUrl
)