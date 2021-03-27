package com.example.nytimesmostpopulararticles.repositories.mostviewedarticles

import com.example.nytimesmostpopulararticles.api.response.MostViewedArticlesListResponse
import com.example.nytimesmostpopulararticles.datasource.remote.mostviewedarticles.MostViewedArticlesRemoteDataSource
import com.example.nytimesmostpopulararticles.vo.Result

class MostViewedArticlesRepositoryImpl(
    private val mostViewedArticlesRemoteDataSource: MostViewedArticlesRemoteDataSource
) : MostViewedArticlesRepository {

    override suspend fun fetchMostViewedArticlesList(): Result<MostViewedArticlesListResponse> {
        return mostViewedArticlesRemoteDataSource.fetchMostViewedArticlesList()
    }
}