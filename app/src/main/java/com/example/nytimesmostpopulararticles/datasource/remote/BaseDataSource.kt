package com.example.nytimesmostpopulararticles.datasource.remote

import com.example.nytimesmostpopulararticles.api.RequestErrorHandler
import com.example.nytimesmostpopulararticles.vo.Result
import retrofit2.HttpException
import retrofit2.Response

open class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        return try {
            val response = call()
            return if (response.isSuccessful) {
                Result.Success(data = response.body())
            } else {
                Result.Error(RequestErrorHandler.getRequestError(HttpException(response)))
            }
        } catch (e: Exception) {
            Result.Error(RequestErrorHandler.getRequestError(e))
        }
    }
}
