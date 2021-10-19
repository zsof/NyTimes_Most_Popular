package hu.kzs.nytimes.data

import hu.kzs.nytimes.data.model.RoomArticle
import hu.kzs.nytimes.model.ArticleModel

fun RoomArticle.toNetworkArticle() = ArticleModel(
    id = id,
    url = url,
    byline = byline,
    title = title,
    publishedDate = publishedDate,
    imageUrl = imageUrl
)

fun ArticleModel.toDiskArticle() = RoomArticle(
    id = id,
    url = url,
    byline = byline,
    title = title,
    publishedDate = publishedDate,
    imageUrl = imageUrl
)