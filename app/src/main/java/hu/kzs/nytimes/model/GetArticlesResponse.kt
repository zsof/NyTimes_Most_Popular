package hu.kzs.nytimes.model

import hu.kzs.nytimes.network.model.ArticleNetwork

data class GetArticlesResponse(
    val results: List<ArticleNetwork>
)