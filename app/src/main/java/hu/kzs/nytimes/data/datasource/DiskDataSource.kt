package hu.kzs.nytimes.data.datasource

import hu.kzs.nytimes.data.model.RoomArticle
import hu.kzs.nytimes.data.dao.ArticleDao
import hu.kzs.nytimes.data.toDiskArticle
import hu.kzs.nytimes.data.toNetworkArticle
import hu.kzs.nytimes.model.ArticleModel
import org.koin.dsl.module

val DiskDataSourceModule = module {
    factory { DiskDataSource(get()) }
}

class DiskDataSource(private val articleDao: ArticleDao) {
    fun getArticles(): List<ArticleModel> {
        return articleDao.getArticles().map(RoomArticle::toNetworkArticle)
    }

    fun refreshArticles(articles: List<ArticleModel>) {
        articleDao.addArticles(articles.map(ArticleModel::toDiskArticle))
    }

    fun getArticleById(articleId: Long): ArticleModel? {
        return articleDao.getArticleById(articleId)?.let(RoomArticle::toNetworkArticle)
    }
}