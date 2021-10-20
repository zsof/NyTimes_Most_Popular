package hu.kzs.nytimes.ui.main

import hu.kzs.nytimes.model.Article

data class MainViewState(
    val articleData: List<Article> = emptyList(),
    var isRefresh: Boolean = false
)
