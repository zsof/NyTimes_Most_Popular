package com.example.blankkoin.ui.main

import co.zsmb.rainbowcake.withIOContext
import com.example.blankkoin.interactor.ArticleInteractor
import com.example.blankkoin.model.ArticleModel

class MainPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(): List<ArticleModel> = withIOContext {
        val articles = articleInteractor.getArticle() ?: return@withIOContext emptyList<ArticleModel>()

        articles.map {
            ArticleModel(
                id = it.id,
                title = it.title,
                byline = it.byline,
                publishedDate = it.publishedDate,
                url = it.url,
                imageUrl = it.imageUrl
            )
        }
    }

    suspend fun replace() = withIOContext {
        articleInteractor.replaceArticle()
    }
}

