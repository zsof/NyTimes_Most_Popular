package com.example.blankkoin.network

import com.example.blankkoin.model.ArticlesData
import com.squareup.moshi.JsonClass
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException


val NetworkModule = module {

    //factory { provideLoggingInterceptor()}
    //factory { provideOkHttpClient(get()) }
    factory { provideArticlesApi(get()) }
    single { provideRetrofit() }

}


fun provideArticlesApi(retrofit: Retrofit): NyTimesApi = retrofit.create(NyTimesApi::class.java)

fun provideRetrofit(): Retrofit {

    return Retrofit.Builder()
        .baseUrl(NyTimesApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
/*fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val h = HttpLoggingInterceptor()
    h.level = HttpLoggingInterceptor.Level.BASIC
    return h
} */

/*fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
} */


/*class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val newUrl = request.url.newBuilder()
                .addQueryParameter("api-key", "ehAQAUVA4b7iGMGO4533WEY4GQZ0Uvn4")
                .build()
        val newRequest = request.newBuilder().url(newUrl).build()

        return chain.proceed(newRequest)
    }

}*/
