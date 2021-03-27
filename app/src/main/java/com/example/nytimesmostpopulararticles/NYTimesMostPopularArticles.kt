package com.example.nytimesmostpopulararticles

import android.app.Application
import com.example.nytimesmostpopulararticles.di.appComponents
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class NYTimesMostPopularArticles : Application() {

    override fun onCreate() {
        super.onCreate()

        configureDI()
    }

    private fun configureDI() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@NYTimesMostPopularArticles)
            modules(provideComponents())
        }
    }

    private fun provideComponents() = appComponents
}