package com.example.nytimesmostpopulararticles.api

import com.example.nytimesmostpopulararticles.BuildConfig
import com.example.nytimesmostpopulararticles.api.response.MostViewedArticlesListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("viewed/{period}.json")
    suspend fun fetchMostViewedArticlesList(
        @Path("period") period: Int = PERIOD,
        @Query("api-key") apiKey: String = API_KEY,
    ): Response<MostViewedArticlesListResponse>

    companion object {
        private const val PERIOD = 7
        private const val API_KEY = BuildConfig.API_KEY
    }
}
