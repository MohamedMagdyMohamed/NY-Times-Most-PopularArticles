package com.example.nytimesmostpopulararticles.repositories.mostviewedarticles

import com.example.nytimesmostpopulararticles.api.response.MostViewedArticlesListResponse
import com.example.nytimesmostpopulararticles.vo.Result

interface MostViewedArticlesRepository {

    suspend fun fetchMostViewedArticlesList(): Result<MostViewedArticlesListResponse>
}
