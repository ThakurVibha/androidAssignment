package com.example.onlinesaleaiassignment.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.onlinesaleaiassignment.repository.MathExpressionRepository

class MathExpressionViewModelFactory(private val mathExpressionRepository: MathExpressionRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MathExpressionViewModel(mathExpressionRepository) as T
    }
}