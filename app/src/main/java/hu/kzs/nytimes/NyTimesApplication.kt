package hu.kzs.nytimes

import android.app.Application
import hu.kzs.nytimes.data.DiskModule
import hu.kzs.nytimes.interactor.ArticleInteractorModule

import hu.kzs.nytimes.network.NetworkModule
import hu.kzs.nytimes.network.NetworkSourceModule
import com.example.blankkoin.ui.UIModule
import hu.kzs.nytimes.data.datasource.DiskDataSourceModule
import hu.kzs.nytimes.ui.main.ArticleAdapterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NyTimesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@NyTimesApplication)
            modules(
                UIModule, NetworkModule, NetworkSourceModule,
                ArticleAdapterModule, DiskModule, ArticleInteractorModule, DiskDataSourceModule
            )
        }
    }
}
