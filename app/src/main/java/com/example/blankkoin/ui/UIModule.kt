package com.example.blankkoin.ui

import com.example.blankkoin.ui.main.MainPresenter
import com.example.blankkoin.ui.main.MainViewModel
import org.koin.dsl.module

val UIModule = module {
    factory { MainPresenter(get()) }
    factory { MainViewModel(get()) }
}