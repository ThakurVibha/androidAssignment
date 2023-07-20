package com.example.onlinesaleaiassignment.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.onlinesaleaiassignment.repository.MathExpressionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MathExpressionViewModel(private val mathExpressionRepository: MathExpressionRepository) :
    ViewModel() {
    fun sendDataToEvaluate(toString: String) {
        CoroutineScope(Dispatchers.IO).launch {
            mathExpressionRepository.getMathExpressionResult(toString)
        }
    }
    val mathExpression: LiveData<String>
        get() = mathExpressionRepository.mathExpression
}