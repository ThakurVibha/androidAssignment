package com.example.onlinesaleaiassignment.api

import com.example.onlinesaleaiassignment.api.MathExpressionHelper.BASE_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MathExpressionService {

    @GET("$BASE_URL")
    suspend fun getMathExpressionResult(@Query("expression")expression:String):Response<String>

}