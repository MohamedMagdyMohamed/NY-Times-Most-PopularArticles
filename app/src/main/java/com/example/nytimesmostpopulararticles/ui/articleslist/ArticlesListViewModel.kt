package com.example.nytimesmostpopulararticles.ui.articleslist

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nytimesmostpopulararticles.api.response.MostViewedArticlesListResponse
import com.example.nytimesmostpopulararticles.repositories.mostviewedarticles.MostViewedArticlesRepository
import com.example.nytimesmostpopulararticles.ui.base.BaseViewModel
import com.example.nytimesmostpopulararticles.vo.Result
import com.example.nytimesmostpopulararticles.vo.ViewedArticle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticlesListViewModel(
    app: Application,
    private val mostViewedArticlesRepository: MostViewedArticlesRepository
) : BaseViewModel(app) {

    init {
        fetchMostViewedArticlesList()
    }

    private var _articlesListResultLiveData = MutableLiveData<Result<List<ViewedArticle>>>()
    val articlesListResultLiveData
        get() = _articlesListResultLiveData

    private fun fetchMostViewedArticlesList() {
        viewModelScope.launch(Dispatchers.IO) {
            _articlesListResultLiveData.postValue(Result.Loading(true))
            val result =
                mostViewedArticlesRepository.fetchMostViewedArticlesList()
            if (result.isSuccess()) {
                val userFollowResponse =
                    (result as Result.Success<MostViewedArticlesListResponse>).data?.results

                _articlesListResultLiveData.postValue(Result.Success(userFollowResponse))
            } else {
                _articlesListResultLiveData.postValue(Result.Error((result as Result.Error).error))
            }
        }
    }
}