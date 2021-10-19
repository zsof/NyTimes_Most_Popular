package hu.kzs.nytimes.data

import hu.kzs.nytimes.model.ArticleModel
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