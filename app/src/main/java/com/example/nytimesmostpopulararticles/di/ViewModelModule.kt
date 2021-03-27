package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.ui.articleslist.ArticlesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ArticlesListViewModel(get(), get()) }
}