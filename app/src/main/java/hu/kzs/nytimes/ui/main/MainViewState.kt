package hu.kzs.nytimes.ui.main

import hu.kzs.nytimes.model.Article

sealed class MainViewState

object Initial : MainViewState()

data class ArticlesReady(
    val articlesData: List<Article>,
    val isRefresh: Boolean = false
) : MainViewState()