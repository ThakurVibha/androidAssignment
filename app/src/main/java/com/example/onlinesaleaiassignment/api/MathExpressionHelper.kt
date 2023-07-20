package com.example.onlinesaleaiassignment.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MathExpressionHelper {
    const val BASE_URL = "https://evaluate-expression.p.rapidapi.com/"
    private const val API_KEY = "0aadaa5ffamsh0af4d7466e48730p1d84c6jsn08503a8e9ab4"
    private const val RAPID_HOST = "evaluate-expression.p.rapidapi.com"

    private val httpClient: OkHttpClient? = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val requestBuilder: Request.Builder = chain.request().newBuilder()
            requestBuilder.header("Content-Type", "application/json")
                .addHeader("X-RapidAPI-Key", API_KEY).addHeader("X-RapidAPI-Host", RAPID_HOST)
            chain.proceed(requestBuilder.build())
        }
        .build()

    private val gson = GsonBuilder().setLenient().create()

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient!!).build()
    }

}