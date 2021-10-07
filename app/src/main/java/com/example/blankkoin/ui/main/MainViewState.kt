package com.example.blankkoin.ui.main

import com.example.blankkoin.model.ArticleModel

data class MainViewState(
    val articleData: List<ArticleModel> = emptyList(),
    var isRefresh: Boolean = false
)
