package com.example.blankkoin.interactor

import com.example.blankkoin.data.DiskDataSource
import com.example.blankkoin.model.ArticleModel
import com.example.blankkoin.network.NetworkDataSource
import org.koin.dsl.module

val ArticleInteractorModule = module {
    single { ArticleInteractor(get(), get()) }
}
class ArticleInteractor (private val networkDataSource: NetworkDataSource, private val diskDataSource: DiskDataSource) {

    fun getArticle() : List<ArticleModel>? {
        return diskDataSource.getArticle()
    }

    suspend fun replaceArticle() {
        val article = networkDataSource.getArticle() ?: return
        diskDataSource.setArticle(article)
    }

     fun getArticleById(articleId: Long) :ArticleModel? {
        return diskDataSource.getArticleById(articleId)
    }
}