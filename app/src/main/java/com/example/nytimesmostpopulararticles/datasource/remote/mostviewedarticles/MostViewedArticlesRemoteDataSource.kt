package com.example.nytimesmostpopulararticles.datasource.remote.mostviewedarticles

import com.example.nytimesmostpopulararticles.api.APIService
import com.example.nytimesmostpopulararticles.api.response.MostViewedArticlesListResponse
import com.example.nytimesmostpopulararticles.datasource.remote.BaseDataSource
import com.example.nytimesmostpopulararticles.vo.Result

class MostViewedArticlesRemoteDataSource(private val apiService: APIService) : BaseDataSource() {

    suspend fun fetchMostViewedArticlesList(): Result<MostViewedArticlesListResponse> {
        return getResult { apiService.fetchMostViewedArticlesList() }
    }
}