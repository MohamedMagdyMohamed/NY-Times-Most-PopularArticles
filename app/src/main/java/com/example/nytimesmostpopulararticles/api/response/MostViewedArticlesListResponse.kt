package com.example.nytimesmostpopulararticles.api.response

import com.example.nytimesmostpopulararticles.vo.ViewedArticle

class MostViewedArticlesListResponse : BaseResponse() {

    var results: ArrayList<ViewedArticle> = ArrayList()
}
