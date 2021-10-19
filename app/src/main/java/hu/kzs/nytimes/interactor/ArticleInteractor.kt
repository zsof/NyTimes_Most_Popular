package hu.kzs.nytimes.interactor

import hu.kzs.nytimes.data.DiskDataSource
import hu.kzs.nytimes.model.ArticleModel
import hu.kzs.nytimes.network.NetworkDataSource
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

     fun getArticleById(articleId: Long) : ArticleModel? {
        return diskDataSource.getArticleById(articleId)
    }
}