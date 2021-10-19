package hu.kzs.nytimes.data

import hu.kzs.nytimes.data.ArticleItem
import hu.kzs.nytimes.model.ArticleModel

fun ArticleItem.toNetworkArticle() = ArticleModel(
    id=id,
    url=url,
    byline=byline,
    title=title,
    publishedDate=publishedDate,
    imageUrl=imageUrl
)

fun ArticleModel.toDiskArticle()= ArticleItem (
    id=id,
    url=url,
    byline=byline,
    title=title,
    publishedDate=publishedDate,
    imageUrl=imageUrl
)