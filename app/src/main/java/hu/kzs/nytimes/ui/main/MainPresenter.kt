package hu.kzs.nytimes.ui.main

import co.zsmb.rainbowcake.withIOContext
import hu.kzs.nytimes.interactor.ArticleInteractor
import hu.kzs.nytimes.model.Article

class MainPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(): List<Article> = withIOContext {
        articleInteractor.getArticles()!!
    }

    suspend fun refresh() = withIOContext {
        articleInteractor.refreshArticles()
    }
}