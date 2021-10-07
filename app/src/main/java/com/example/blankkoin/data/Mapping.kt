package com.example.blankkoin.data

import com.example.blankkoin.model.ArticleModel

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