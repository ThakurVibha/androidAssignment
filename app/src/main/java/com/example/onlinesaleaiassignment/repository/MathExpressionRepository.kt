package com.example.onlinesaleaiassignment.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onlinesaleaiassignment.api.MathExpressionService
import com.example.onlinesaleaiassignment.room.database.MathExpressionDatabase
import com.example.onlinesaleaiassignment.room.entity.MathExpressionEntity
import java.util.Random

class MathExpressionRepository(private val mathExpressionService: MathExpressionService, private val mathExpressionDatabase: MathExpressionDatabase) {

    private val mathExpressionResult = MutableLiveData<String>()

    val mathExpression: LiveData<String>
        get() = mathExpressionResult

    suspend fun getMathExpressionResult(toString: String) {
        val result = mathExpressionService.getMathExpressionResult(toString)
        Log.d("getResult", "$result")
        if (result.body() != null) {
            //saving data to database

            //to generate unique id
            val generatedSet = mutableSetOf<Int>()
            var uniqueId:Int?=null
            for (i in 1..10) {
                uniqueId = generateUniqueRandomInt(1, 100, generatedSet)
            }

            val myExpressionData= uniqueId?.let { MathExpressionEntity(it, result.body()!!) }
            myExpressionData?.let { mathExpressionDatabase.myDataDao().insertData(it) }
            mathExpressionResult.postValue(result.body())
        }
    }
    private fun generateUniqueRandomInt(min: Int, max: Int, generatedSet: MutableSet<Int>): Int {
        val random = Random()
        var randomNumber = random.nextInt(max - min + 1) + min

        while (generatedSet.contains(randomNumber)) {
            randomNumber = random.nextInt(max - min + 1) + min
        }

        generatedSet.add(randomNumber)
        return randomNumber
    }
}