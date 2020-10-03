package com.epam.valkaryne.footballteamsapp.data.di

import com.epam.valkaryne.footballteamsapp.BuildConfig
import com.epam.valkaryne.footballteamsapp.data.api.retrofit.FootballDataApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val URL_BASE = "https://api.football-data.org/"

val retrofitModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofitInstance(client = get()) }
}

private fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
    .addInterceptor { chain ->
        val request =
            chain.request().newBuilder().addHeader("X-Auth-Token", BuildConfig.X_AUTH_TOKEN)
                .build()
        chain.proceed(request)
    }
    .build()

private fun provideRetrofitInstance(client: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(URL_BASE)
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

val footballDataApiModule = module {
    factory { provideFootballDataApiService(retrofit = get()) }
}

private fun provideFootballDataApiService(retrofit: Retrofit): FootballDataApiService =
    retrofit.create(FootballDataApiService::class.java)