package hu.kzs.nytimes.ui.details

import co.zsmb.rainbowcake.withIOContext
import hu.kzs.nytimes.interactor.ArticleInteractor
import hu.kzs.nytimes.model.Article

class DetailsPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(articleId: Long): Article? = withIOContext {
        articleInteractor.getArticleById(articleId)?.let {
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
}


