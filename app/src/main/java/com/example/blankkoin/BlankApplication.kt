package com.example.blankkoin

import android.app.Application

import com.example.blankkoin.network.NetworkModule
import com.example.blankkoin.network.NetworkSourceModule
import com.example.blankkoin.ui.UIModule
import com.example.blankkoin.ui.main.ArticleAdapterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BlankApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BlankApplication)
            modules(
                UIModule, NetworkModule, NetworkSourceModule,
                ArticleAdapterModule
            )
        }
    }

}
