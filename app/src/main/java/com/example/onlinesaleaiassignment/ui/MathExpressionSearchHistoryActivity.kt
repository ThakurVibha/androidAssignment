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
    private var mathExpressionHistoryData:List<MathExpressionEntity>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_history)

        //Here we are fetching data from database
        CoroutineScope(Dispatchers.IO).launch {
            val mathExpressionDatabase = MathExpressionDatabase.getDatabase(applicationContext)
             mathExpressionHistoryData = mathExpressionDatabase.myDataDao().getAllData()
            Log.e(
                "getAllData", "$mathExpressionHistoryData"
            )
        }
        historyAdapter = HistoryAdapter(mathExpressionHistoryData!!)
        binding.rvHistory.adapter = historyAdapter

    }
}