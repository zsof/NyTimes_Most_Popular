package com.example.blankkoin.ui.main

import co.zsmb.rainbowcake.withIOContext
import com.example.blankkoin.interactor.ArticleInteractor
import com.example.blankkoin.model.Article

import com.example.blankkoin.network.NetworkDataSource

class MainPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(): List<Article> = withIOContext {
        val articles = articleInteractor.getArticle() ?: return@withIOContext emptyList<Article>()

        articles.map {
            Article(
                id = it.id,
                title = it.title,
                byline = it.byline,
                publishedDate = it.publishedDate,
                url = it.url
            )
        }
    }

    suspend fun replace() = withIOContext {
        articleInteractor.replaceArticle()
    }
}

