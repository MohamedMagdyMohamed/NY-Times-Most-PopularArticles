package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.BuildConfig
import com.example.nytimesmostpopulararticles.api.APIService
import com.example.nytimesmostpopulararticles.utils.GsonBooleanTypeAdapter
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitModule = module {
    single { okHttp() }
    single { retrofit(get()) }
    single { retrofit(get()).create(APIService::class.java) }
}

private fun retrofit(client: OkHttpClient) =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(getGsonConverterFactory())
        .build()

private fun getGsonConverterFactory(): Converter.Factory {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.registerTypeAdapter(Boolean::class.java, GsonBooleanTypeAdapter())
    val gson = gsonBuilder.create()
    return GsonConverterFactory.create(gson)
}

private val requestBodyLoggerInterceptor: Interceptor
    get() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

private val requestHeaderLoggerInterceptor: Interceptor
    get() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.HEADERS
        else HttpLoggingInterceptor.Level.NONE
    }

private fun okHttp() =
    OkHttpClient.Builder()
        .addInterceptor(requestBodyLoggerInterceptor)
        .addInterceptor(requestHeaderLoggerInterceptor)
        .build()