package hu.kzs.nytimes.interactor

import hu.kzs.nytimes.data.datasource.DiskDataSource
import hu.kzs.nytimes.model.Article
import hu.kzs.nytimes.network.NetworkDataSource
import org.koin.dsl.module

val ArticleInteractorModule = module {
    single { ArticleInteractor(get(), get()) }
}

class ArticleInteractor(
    private val networkDataSource: NetworkDataSource,
    private val diskDataSource: DiskDataSource
) {

    fun getArticles(): List<Article>? {
        return diskDataSource.getArticles()
    }

    suspend fun refreshArticles() {
        val article = networkDataSource.getArticles() ?: return
        diskDataSource.refreshArticles(article)
    }

    fun getArticleById(articleId: Long): Article? {
        return diskDataSource.getArticleById(articleId)
    }
}