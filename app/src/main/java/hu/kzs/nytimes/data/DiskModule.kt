package hu.kzs.nytimes.data

import android.content.Context
import androidx.room.Room
import hu.kzs.nytimes.data.dao.ArticleDao
import org.koin.dsl.module

val DiskModule = module {
    single { provideDao(get()) }
    single { provideArticleDatabase(get()) }
}

fun provideDao(articleDatabase: ArticleDatabase): ArticleDao {
    return articleDatabase.articleDao()
}

fun provideArticleDatabase(context: Context): ArticleDatabase {
    return Room.databaseBuilder(context, ArticleDatabase::class.java, "article_db").build()
}