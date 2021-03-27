package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.datasource.remote.mostviewedarticles.MostViewedArticlesRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    factory { MostViewedArticlesRemoteDataSource(get()) }
}
