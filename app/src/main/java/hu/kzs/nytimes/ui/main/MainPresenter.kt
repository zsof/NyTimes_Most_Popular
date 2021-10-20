package hu.kzs.nytimes.ui.main

import co.zsmb.rainbowcake.withIOContext
import hu.kzs.nytimes.interactor.ArticleInteractor
import hu.kzs.nytimes.model.Article

class MainPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(): List<Article> = withIOContext {
        val articles =
            articleInteractor.getArticles() ?: return@withIOContext emptyList<Article>()

        articles.map {
            Article(
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
        articleInteractor.refreshArticles()
    }
}

