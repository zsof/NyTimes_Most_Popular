package com.example.blankkoin.data

import com.example.blankkoin.model.Article
import org.koin.core.scope.get
import org.koin.dsl.module

val DiskDataSourceModule = module {
    factory { DiskDataSource(get()) }
}
class DiskDataSource (private val articleDao: ArticleDao) {
    fun getArticle() : List<Article> {
        return articleDao.getArticle().map(ArticleItem::toNetworkArticle)
    }

    fun setArticle(articles: List<Article>) {
        articleDao.replaceArticle(articles.map (Article::toDiskArticle))
    }

    fun getArticleById(articleId: Long): Article? {
      return articleDao.getArticleById(articleId)?.let(ArticleItem::toNetworkArticle)
    }
}