package hu.kzs.nytimes.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel

class DetailsViewModel(
    private val detailsPresenter: DetailsPresenter
) : RainbowCakeViewModel<DetailsViewState>(Loading) {

    fun load(articleId: Long) = execute {
        viewState = ArticleLoad(detailsPresenter.getArticle(articleId))
    }
}