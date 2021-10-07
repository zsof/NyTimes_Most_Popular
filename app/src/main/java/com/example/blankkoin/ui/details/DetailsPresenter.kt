
package com.example.blankkoin.ui.details

import co.zsmb.rainbowcake.withIOContext
import com.example.blankkoin.interactor.ArticleInteractor
import com.example.blankkoin.model.Article

import com.example.blankkoin.network.NetworkDataSource

class DetailsPresenter (private val articleInteractor: ArticleInteractor) {

    suspend fun getArticles(articleId: Long): Article? = withIOContext {
       articleInteractor.getArticleById(articleId)?.let {
           Article(
               id=it.id,
               title = it.title,
               byline = it.byline,
               publishedDate = it.publishedDate,
               url = it.url
           )
       }
    }


    /*  suspend fun getUrl(articleId: Long): String? = withIOContext {
          articleInteractor.getArticleById(articleId)?.url
      } */

    /* data class ArticleDetail(
            val title: String,
            val imageUrl: String?,
            val byline: String,
            val date: String
    ) */
}


