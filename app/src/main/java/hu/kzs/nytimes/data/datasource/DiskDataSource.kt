package hu.kzs.nytimes.data.datasource

import hu.kzs.nytimes.data.model.RoomArticle
import hu.kzs.nytimes.data.dao.ArticleDao
import hu.kzs.nytimes.data.toDiskArticle
import hu.kzs.nytimes.data.toNetworkArticle
import hu.kzs.nytimes.model.Article
import org.koin.dsl.module

val DiskDataSourceModule = module {
    factory { DiskDataSource(get()) }
}

class DiskDataSource(private val articleDao: ArticleDao) {
    fun getArticles(): List<Article> {
        return articleDao.getArticles().map(RoomArticle::toNetworkArticle)
    }

    fun refreshArticles(articles: List<Article>) {
        articleDao.addArticles(articles.map(Article::toDiskArticle))
    }

    fun getArticleById(articleId: Long): Article? {
        return articleDao.getArticleById(articleId)?.let(RoomArticle::toNetworkArticle)
    }
}