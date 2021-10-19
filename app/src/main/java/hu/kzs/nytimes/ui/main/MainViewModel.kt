package hu.kzs.nytimes.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeViewModel

class MainViewModel(
    private val mainPresenter: MainPresenter
) : RainbowCakeViewModel<MainViewState>(MainViewState()) {

    fun load() = execute {
        viewState = MainViewState(mainPresenter.getArticles())
        mainPresenter.replace()
        viewState = MainViewState(mainPresenter.getArticles())

    }

    fun replaceArticle()=execute {
        viewState = viewState.copy(isRefresh = true)
        mainPresenter.replace()
        viewState= MainViewState(articleData = mainPresenter.getArticles(), isRefresh = false)
    }
}
