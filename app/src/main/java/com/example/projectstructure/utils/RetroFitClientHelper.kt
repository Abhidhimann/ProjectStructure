package com.example.projectstructure.utils

import com.example.projectstructure.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetroFitClientHelper() {
    @Volatile
    private var retrofit: Retrofit? = null

    fun getApiClient(baseUrl: String, headers: Headers? = null): Retrofit {
        val gson = GsonBuilder().setLenient().create()

        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient =
            OkHttpClient.Builder()
                .readTimeout(Api.TIME_OUT.getValue().toLong(), TimeUnit.SECONDS)
                .connectTimeout(Api.TIME_OUT.getValue().toLong(), TimeUnit.SECONDS)
                .writeTimeout(Api.TIME_OUT.getValue().toLong(), TimeUnit.SECONDS)
                .apply {
                    if (BuildConfig.DEBUG) {
//                        addInterceptor(logging)
                    }
                    addInterceptor { chain ->
                        // Append API key as a query parameter
//                        val originalUrl = chain.request().url
//                        val newUrl = originalUrl.newBuilder()
//                            .addQueryParameter("api key", "api") // Adds API key dynamically
//                            .build()

                        val newRequest: Request = if (headers != null) {
                            chain.request().newBuilder()
                                .headers(headers)
//                                .url(newUrl)
                                .build()
                        } else {
                            chain.request().newBuilder()
                                .build()
                        }
                        chain.proceed(newRequest)
                    }
                }
                .build()


        if (retrofit == null) {
            retrofit = synchronized(this) {
                Retrofit.Builder().baseUrl(baseUrl).client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build()
            }
        }

        return retrofit ?: throw IllegalStateException("Retrofit instance not initialized")
    }
}