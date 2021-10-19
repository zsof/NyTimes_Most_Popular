package hu.kzs.nytimes.ui.details

import co.zsmb.rainbowcake.base.RainbowCakeViewModel

class DetailsViewModel(
    private val detailsPresenter: DetailsPresenter
) : RainbowCakeViewModel<DetailsViewState>(DetailsViewState()) {

    fun load(articleId:Long) = execute {
        viewState = DetailsViewState(detailsPresenter.getArticles(articleId))
    }
}

