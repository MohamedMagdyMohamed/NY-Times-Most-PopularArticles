package com.example.nytimesmostpopulararticles.ui.articledetail

import android.app.Application
import com.example.nytimesmostpopulararticles.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles.vo.ViewedArticle

class ArticleDetailViewModel(app: Application) : BaseViewModel(app) {

    lateinit var viewArticle: ViewedArticle
}