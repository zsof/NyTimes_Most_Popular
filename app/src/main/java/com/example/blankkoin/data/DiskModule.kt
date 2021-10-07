package com.example.blankkoin.data

import android.content.Context
import androidx.room.Room
import org.koin.dsl.module

val DiskModule = module {
    single { provideDao(get()) }
    single { provideArticleDatabase(get()) }
}

fun provideDao(articleDatabase: ArticleDatabase): ArticleDao {
    return articleDatabase.articleItemDao()
}

fun provideArticleDatabase(context: Context): ArticleDatabase {
    return Room.databaseBuilder(context, ArticleDatabase::class.java, "article_db").build()
}