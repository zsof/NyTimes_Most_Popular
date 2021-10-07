package com.example.blankkoin.network

import com.example.blankkoin.model.Article
import org.koin.dsl.module
import retrofit2.HttpException
import java.io.IOException

val NetworkSourceModule = module {
    factory { NetworkDataSource(get()) }
}
class NetworkDataSource (private val api: NyTimesApi) {
    suspend fun getArticle(): List<Article>? {

        val articles = try {
            api.getArticles()

        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } catch (e: HttpException){
            e.printStackTrace()
            return null
        }
        return articles.results
    }
}