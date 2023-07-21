package com.example.onlinesaleaiassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.onlinesaleaiassignment.R
import com.example.onlinesaleaiassignment.databinding.ActivitySearchHistoryBinding
import com.example.onlinesaleaiassignment.room.database.MathExpressionDatabase
import com.example.onlinesaleaiassignment.room.entity.MathExpressionEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MathExpressionSearchHistoryActivity : AppCompatActivity() {
    lateinit var historyAdapter: HistoryAdapter
    lateinit var binding: ActivitySearchHistoryBinding
    val mathExpressionHistoryList: MutableList<MathExpressionEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_history)

        //Here we are fetching data from database
        CoroutineScope(Dispatchers.IO).launch {
            val mathExpressionDatabase = MathExpressionDatabase.getDatabase(applicationContext)
            mathExpressionHistoryList.addAll(mathExpressionDatabase.myDataDao().getAllData())
            Log.e(
                "getAllData", "$mathExpressionHistoryList"
            )
        }
        historyAdapter = HistoryAdapter(mathExpressionHistoryList!!)
        binding.rvHistory.adapter = historyAdapter

    }
}