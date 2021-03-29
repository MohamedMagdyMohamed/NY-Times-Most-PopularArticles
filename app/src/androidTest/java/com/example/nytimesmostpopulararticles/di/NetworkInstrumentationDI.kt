package com.example.nytimesmostpopulararticles.di

import com.example.nytimesmostpopulararticles.api.APIService
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Retrofit Koin DI component for Instrumentation Testing
 */
fun configureNetworkForInstrumentationTest(baseTestApi: String) = module {

    single(override = true) {
        Retrofit.Builder()
            .baseUrl(baseTestApi)
            .addConverterFactory(getGsonConverterFactory())
            .build()
    }
    factory(override = true) { get<Retrofit>().create(APIService::class.java) }
}

