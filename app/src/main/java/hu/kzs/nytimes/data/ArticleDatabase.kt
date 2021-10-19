package hu.kzs.nytimes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.kzs.nytimes.data.dao.ArticleDao
import hu.kzs.nytimes.data.model.RoomArticle

@Database(entities = [RoomArticle::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}