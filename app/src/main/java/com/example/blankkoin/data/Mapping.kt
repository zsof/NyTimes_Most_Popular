package com.example.blankkoin.data

import com.example.blankkoin.model.Article

fun ArticleItem.toNetworkArticle() = Article(
    id=id,
    url=url,
    byline=byline,
    title=title,
    publishedDate=publishedDate
)

fun Article.toDiskArticle()= ArticleItem (
    id=id,
    url=url,
    byline=byline,
    title=title,
    publishedDate=publishedDate
)