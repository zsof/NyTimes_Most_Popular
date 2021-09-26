package com.example.blankkoin.ui.main

import co.zsmb.rainbowcake.withIOContext

import com.example.blankkoin.network.NetworkDataSource

class MainPresenter (private val nds: NetworkDataSource) {

    data class ArticlesPresenterData(
        val id: Long,
        val title: String,
        val published_date: String,
        val byline: String,
        val url: String
    )

    suspend fun getArticles(): List<ArticlesPresenterData> = withIOContext {


        val articles = nds.getArticle() ?: return@withIOContext emptyList<ArticlesPresenterData>()

        articles.map {
            ArticlesPresenterData(
                id = it.id,
                title = it.title,
                byline = it.byline,
                published_date = it.published_date,
                url = it.url
            )
        }

    }
}

