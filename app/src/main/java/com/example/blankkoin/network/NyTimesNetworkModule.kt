package com.example.blankkoin.network

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {

    //factory { provideLoggingInterceptor()}
    //factory { provideOkHttpClient(get()) }
    factory { provideNyTimesApi(get()) }
    factory { provideRetrofit() }

}
fun provideNyTimesApi(retrofit: Retrofit): NyTimesApi = retrofit.create()

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
