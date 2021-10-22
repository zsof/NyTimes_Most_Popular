package hu.kzs.nytimes.ui.details

import co.zsmb.rainbowcake.withIOContext
import hu.kzs.nytimes.interactor.ArticleInteractor
import hu.kzs.nytimes.model.Article

class DetailsPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticle(articleId: Long): Article? = withIOContext {
        articleInteractor.getArticleById(articleId)
    }
}