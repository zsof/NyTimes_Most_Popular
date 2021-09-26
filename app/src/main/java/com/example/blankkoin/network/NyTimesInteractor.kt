package com.example.blankkoin.network

import com.example.blankkoin.model.ArticlesData
import org.koin.dsl.module


val NetworkSourceModule = module {
    factory { NetworkDataSource(get()) }
}

class NetworkDataSource (private val api: NyTimesApi) {

    suspend fun getArticle(): List<ArticlesData>? {


        val articles = try {
            api.getArticles()

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

        return articles.results.map { network ->
            ArticlesData(
                id = network.id,
                url = network.url,
                byline = network.byline,
                title = network.title,
                published_date = network.published_date
            )
        }
    }
}