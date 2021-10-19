package com.example.blankkoin.ui

import hu.kzs.nytimes.ui.details.DetailsPresenter
import hu.kzs.nytimes.ui.details.DetailsViewModel
import hu.kzs.nytimes.ui.main.MainPresenter
import hu.kzs.nytimes.ui.main.MainViewModel
import org.koin.dsl.module

val UIModule = module {
    factory { MainPresenter(get()) }
    factory { MainViewModel(get()) }
    factory { DetailsPresenter(get()) }
    factory { DetailsViewModel(get()) }
}