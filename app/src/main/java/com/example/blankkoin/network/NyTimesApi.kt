package com.example.blankkoin.network

import com.example.blankkoin.model.GetArticlesData
import retrofit2.http.GET
import retrofit2.http.Query

interface NyTimesApi {

    companion object {
        const val BASE_URL="https://api.nytimes.com/svc/mostpopular/v2/"
        const val KEY ="ehAQAUVA4b7iGMGO4533WEY4GQZ0Uvn4"
    }

    @GET("viewed/1.json")
    suspend fun getArticles(
        @Query("api-key") apiKey :String = KEY
    ): GetArticlesData
}