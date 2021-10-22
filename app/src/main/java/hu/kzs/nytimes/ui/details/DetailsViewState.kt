package hu.kzs.nytimes.ui.details

import hu.kzs.nytimes.model.Article

sealed class DetailsViewState

object Loading : DetailsViewState()

data class ArticleLoad(
    val detailArticle: Article? = null
) : DetailsViewState()
