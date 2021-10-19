package hu.kzs.nytimes.ui.main

import hu.kzs.nytimes.model.ArticleModel

data class MainViewState(
    val articleData: List<ArticleModel> = emptyList(),
    var isRefresh: Boolean = false
)
