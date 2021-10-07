package com.example.blankkoin.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.blankkoin.model.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getArticle(): List<ArticleItem>

    @Query("DELETE FROM article")
    fun deleteArticle()

    @Insert
    fun addArticle(articles: List<ArticleItem>)

    @Transaction
    fun replaceArticle(articles: List<ArticleItem>) {
        deleteArticle()
        addArticle(articles)
    }
    @Query("SELECT * FROM article WHERE id = :articleId")
    fun getArticleById(articleId: Long): ArticleItem?

}