package com.example.blankkoin.network

import com.example.blankkoin.model.ArticleModel
import org.koin.dsl.module
import retrofit2.HttpException
import java.io.IOException

val NetworkSourceModule = module {
    factory { NetworkDataSource(get()) }
}
class NetworkDataSource (private val api: NyTimesApi) {
    suspend fun getArticle(): List<ArticleModel>? {
        val articles = try {
            api.getArticles()
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } catch (e: HttpException){
            e.printStackTrace()
            return null
        }

        return articles.results.map { it ->
            val imageData=it.media.find { it.type == "image" }?.mediaMetadata

            ArticleModel(
                id = it.id,
                url=it.url,
                title = it.title,
                byline = it.byline,
                publishedDate = it.publishedDate,
                imageUrl = imageData?.find { it.format =="Standard Thumbnail" }?.url
            )
        }
    }
}