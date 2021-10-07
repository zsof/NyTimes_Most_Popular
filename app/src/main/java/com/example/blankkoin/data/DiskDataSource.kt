package com.example.blankkoin.data

import com.example.blankkoin.model.ArticleModel
import org.koin.dsl.module

val DiskDataSourceModule = module {
    factory { DiskDataSource(get()) }
}
class DiskDataSource (private val articleDao: ArticleDao) {
    fun getArticle() : List<ArticleModel> {
        return articleDao.getArticle().map(ArticleItem::toNetworkArticle)
    }

    fun setArticle(articles: List<ArticleModel>) {
        articleDao.replaceArticle(articles.map (ArticleModel::toDiskArticle))
    }

    fun getArticleById(articleId: Long): ArticleModel? {
      return articleDao.getArticleById(articleId)?.let(ArticleItem::toNetworkArticle)
    }
}