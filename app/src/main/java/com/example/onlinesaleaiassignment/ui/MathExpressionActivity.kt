package com.example.onlinesaleaiassignment.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.onlinesaleaiassignment.MathExpressionApp
import com.example.onlinesaleaiassignment.R
import com.example.onlinesaleaiassignment.databinding.ActivityMathExpressionBinding
import com.example.onlinesaleaiassignment.viewmodels.MathExpressionViewModel
import com.example.onlinesaleaiassignment.viewmodels.MathExpressionViewModelFactory


class MathExpressionActivity : AppCompatActivity() {
    lateinit var mathExpressionViewModel: MathExpressionViewModel
    lateinit var binding: ActivityMathExpressionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_math_expression)
        initViewModel()
        observeData()

        binding.btnSolve.setOnClickListener {
           if(validation()){
               mathExpressionViewModel.sendDataToEvaluate(binding.etEnterData.text.toString())
           }
        }
        binding.ivHistory.setOnClickListener {
            startActivity(Intent(this, MathExpressionSearchHistoryActivity::class.java))
        }
    }


    private fun initViewModel() {
        //get the reference of repository
        val mathExpressionRepository = (application as MathExpressionApp).mathExpressionRepository
        mathExpressionViewModel =
            ViewModelProvider(this, MathExpressionViewModelFactory(mathExpressionRepository)).get(
                MathExpressionViewModel::class.java
            )
    }

    private fun observeData() {
        mathExpressionViewModel.mathExpression.observe(this, Observer {
            binding.tvResult.text = it.toString()
        })
    }

    private fun validation(): Boolean {
        if (binding.etEnterData.text.toString().isBlank()
        ) {
           binding.etEnterData.error="Please enter mathematical expression"
            return false
        }
        if (binding.etEnterData.text.toString().isEmpty()
        ) {
            binding.etEnterData.error="Please enter mathematical expression"
            return false
        }
        return true
    }

}