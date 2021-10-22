package hu.kzs.nytimes.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeViewModel

class MainViewModel(
    private val mainPresenter: MainPresenter
) : RainbowCakeViewModel<MainViewState>(Initial) {

    fun load() = execute {
        viewState = ArticlesReady(mainPresenter.getArticles())
        mainPresenter.refresh()
        viewState = ArticlesReady(mainPresenter.getArticles())

    }

    fun refreshArticle() = execute {
        mainPresenter.refresh()
        viewState = ArticlesReady(articlesData = mainPresenter.getArticles(), isRefresh = false)
    }
}