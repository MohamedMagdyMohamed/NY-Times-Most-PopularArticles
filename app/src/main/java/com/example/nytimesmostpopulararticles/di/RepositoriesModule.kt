package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.repositories.mostviewedarticles.MostViewedArticlesRepository
import com.example.nytimesmostpopulararticles.repositories.mostviewedarticles.MostViewedArticlesRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    factory<MostViewedArticlesRepository> { MostViewedArticlesRepositoryImpl(get()) }
}
