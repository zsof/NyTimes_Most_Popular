package com.example.blankkoin.ui.main

import com.example.blankkoin.model.Article

data class MainViewState(
    val articleData: List<Article> = emptyList(),
    var isRefresh: Boolean = false
)
