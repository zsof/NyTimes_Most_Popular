package com.example.blankkoin.ui.main

import co.zsmb.rainbowcake.base.RainbowCakeViewModel

class MainViewModel(
    private val mainPresenter: MainPresenter
) : RainbowCakeViewModel<MainViewState>(MainViewState()) {

    fun load() = execute {
        viewState = MainViewState(mainPresenter.getArticles())
        mainPresenter.getArticles()



    }



}
