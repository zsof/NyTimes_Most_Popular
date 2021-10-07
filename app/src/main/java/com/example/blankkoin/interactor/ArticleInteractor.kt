package com.example.blankkoin.interactor

import com.example.blankkoin.data.ArticleItem
import com.example.blankkoin.data.DiskDataSource
import com.example.blankkoin.model.Article
import com.example.blankkoin.network.NetworkDataSource
import org.koin.dsl.module

val ArticleInteractorModule = module {
    single { ArticleInteractor(get(), get()) }
}
class ArticleInteractor (private val networkDataSource: NetworkDataSource, private val diskDataSource: DiskDataSource) {

    var articleId: Long=0
    fun getArticle() : List<Article>? {
        return diskDataSource.getArticle()
    }

    suspend fun replaceArticle() {
        val article = networkDataSource.getArticle() ?: return
        diskDataSource.setArticle(article)

    }

     fun getArticleById(articleId: Long) :Article? {
        return diskDataSource.getArticleById(articleId)
    }


}