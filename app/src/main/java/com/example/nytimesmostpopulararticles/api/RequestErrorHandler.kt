package com.example.nytimesmostpopulararticles.api

import com.example.nytimesmostpopulararticles.R
import com.example.nytimesmostpopulararticles.api.response.BaseResponse
import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.util.concurrent.CancellationException

object RequestErrorHandler {

    fun getRequestError(throwable: Throwable): ResultException {
        return when (throwable) {
            is CancellationException -> {
                ResultException.Client(errorCode = HTTP_CODE_CLIENT_CANCEL_REQUEST)
            }
            is HttpException -> {
                handleHttpException(throwable)
            }
            is SocketTimeoutException -> {
                ResultException.Timeout(R.string.error_timeout_message)
            }
            is IOException -> {
                ResultException.Connection(R.string.error_no_connectivity_message)
            }
            else -> {
                val message = throwable.message
                if (message != null) {
                    ResultException.ApiError(message = message)
                } else {
                    ResultException.Unexpected(R.string.error_unexpected_message)
                }
            }
        }
    }

    private fun handleHttpException(httpException: HttpException): ResultException {
        val errorCode = httpException.code()
        val errorMessage = getErrorMessage(httpException.response())
        if (errorMessage != null) return ResultException.ApiError(errorCode, errorMessage)

        return when (errorCode) {
            in HTTP_CODE_CLIENT_START..HTTP_CODE_CLIENT_END -> {
                ResultException.Client(R.string.error_client_message, errorCode)
            }
            in HTTP_CODE_SERVER_START..HTTP_CODE_SERVER_END -> {
                ResultException.Server(R.string.error_server_message, errorCode)
            }
            else -> {
                ResultException.Unexpected(R.string.error_unexpected_message, errorCode)
            }
        }
    }

    private fun getErrorMessage(response: Response<*>?): String? {
        val errorBody = response?.errorBody()
        return if (errorBody != null) {
            Gson().fromJson(errorBody.string(), BaseResponse::class.java)?.fault?.faultString
        } else {
            null
        }
    }

    private const val HTTP_CODE_CLIENT_CANCEL_REQUEST = 6666
    private const val HTTP_CODE_CLIENT_START = 400
    private const val HTTP_CODE_CLIENT_END = 499
    private const val HTTP_CODE_SERVER_START = 500
    private const val HTTP_CODE_SERVER_END = 599
}
