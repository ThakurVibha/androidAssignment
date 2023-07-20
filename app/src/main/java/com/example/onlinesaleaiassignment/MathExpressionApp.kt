package com.example.onlinesaleaiassignment

import android.app.Application
import com.example.onlinesaleaiassignment.api.MathExpressionHelper
import com.example.onlinesaleaiassignment.api.MathExpressionService
import com.example.onlinesaleaiassignment.repository.MathExpressionRepository
import com.example.onlinesaleaiassignment.room.database.MathExpressionDatabase

class MathExpressionApp : Application() {

    //we have created repository reference as a singleton and it will be accessible everywhere
    //This ensures that all ViewModel instances have access to the same repository

    lateinit var mathExpressionRepository: MathExpressionRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val mathExpressionService =
            MathExpressionHelper.getInstance().create(MathExpressionService::class.java)
        val mathExpressionDatabase = MathExpressionDatabase.getDatabase(applicationContext)
        mathExpressionRepository =
            MathExpressionRepository(mathExpressionService, mathExpressionDatabase)
    }

}