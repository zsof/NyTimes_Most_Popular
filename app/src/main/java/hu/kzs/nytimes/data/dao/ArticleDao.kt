package hu.kzs.nytimes.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import hu.kzs.nytimes.data.model.RoomArticle

@Dao
interface ArticleDao {
    @Query("SELECT * FROM article")
    fun getArticles(): List<RoomArticle>

    @Query("DELETE FROM article")
    fun deleteArticle()

    @Insert(onConflict = REPLACE)
    fun addArticles(roomArticles: List<RoomArticle>)

    @Query("SELECT * FROM article WHERE id = :articleId")
    fun getArticleById(articleId: Long): RoomArticle?
}