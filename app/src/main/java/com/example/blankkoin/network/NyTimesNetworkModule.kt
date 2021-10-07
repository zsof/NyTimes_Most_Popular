package com.example.blankkoin.network

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.converter.gson.GsonConverterFactory


val NetworkModule = module {

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