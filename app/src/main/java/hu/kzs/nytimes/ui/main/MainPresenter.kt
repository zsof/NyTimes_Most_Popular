package hu.kzs.nytimes.ui.main

import co.zsmb.rainbowcake.withIOContext
import hu.kzs.nytimes.interactor.ArticleInteractor
import hu.kzs.nytimes.model.ArticleModel

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

