package com.example.nytimesmostpopulararticles.di

/**
 * Main Koin DI component for Instrumentation Testing
 */
fun generateTestAppComponent(baseApi: String)
        = listOf(
    dataSourceModule,
    configureNetworkForInstrumentationTest(baseApi),
    MockWebServerInstrumentationTest,
    repositoriesModule
)