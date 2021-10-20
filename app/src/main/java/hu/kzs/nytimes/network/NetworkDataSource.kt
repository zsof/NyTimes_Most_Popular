package hu.kzs.nytimes.network

import hu.kzs.nytimes.model.Article
import org.koin.dsl.module
import retrofit2.HttpException
import java.io.IOException

val NetworkSourceModule = module {
    factory { NetworkDataSource(get()) }
}
class NetworkDataSource (private val api: NyTimesApi) {
    companion object {
        const val IMAGE_TYPE = "image"
        const val FORMAT_TYPE = "Standard Thumbnail"
    }

    suspend fun getArticles(): List<Article>? {
        val articles = try {
            api.getArticles()
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        } catch (e: HttpException) {
            e.printStackTrace()
            return null
        }


        return articles.results.map { it ->
            val imageData = it.media.find { it.type == IMAGE_TYPE }?.mediaMetadata

            Article(
                id = it.id,
                url = it.url,
                title = it.title,
                byline = it.byline,
                publishedDate = it.publishedDate,
                imageUrl = imageData?.find { it.format == FORMAT_TYPE }?.url
            )
        }
    }
}