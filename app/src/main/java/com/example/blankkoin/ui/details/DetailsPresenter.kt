package com.example.blankkoin.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.example.blankkoin.interactor.ArticleInteractor
import com.example.blankkoin.model.ArticleModel

class DetailsPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(articleId: Long): ArticleModel? = withIOContext {
       articleInteractor.getArticleById(articleId)?.let {
           ArticleModel(
               id=it.id,
               title = it.title,
               byline = it.byline,
               publishedDate = it.publishedDate,
               url = it.url,
               imageUrl = it.imageUrl
           )
       }
    }
}


