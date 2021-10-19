package hu.kzs.nytimes.model

import hu.kzs.nytimes.model.Article

data class GetArticlesData(
    val results:List<Article>
)