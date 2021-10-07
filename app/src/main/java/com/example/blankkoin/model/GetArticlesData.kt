package com.example.blankkoin.model

import com.squareup.moshi.JsonClass

//@JsonClass(generateAdapter = true)
data class GetArticlesData(
    val results:List<Article>
)