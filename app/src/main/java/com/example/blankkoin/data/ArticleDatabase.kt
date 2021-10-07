package com.example.blankkoin.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ArticleItem::class], version = 1)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun articleItemDao(): ArticleDao
}