package hu.kzs.nytimes.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val NetworkModule = module {

    factory { provideNyTimesApi(get()) }
    factory { provideRetrofit() }

}
fun provideNyTimesApi(retrofit: Retrofit): NyTimesApi = retrofit.create()

fun provideRetrofit(): Retrofit {

    val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
    }.build()

    return Retrofit.Builder()
        .baseUrl(NyTimesApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}