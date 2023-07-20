package com.example.onlinesaleaiassignment.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.onlinesaleaiassignment.room.entity.MathExpressionEntity
@Dao
interface MathExpressionDao {
    @Insert
    suspend fun insertData(data: MathExpressionEntity)

    @Query("SELECT * FROM my_data_table")
    suspend fun getAllData(): List<MathExpressionEntity>
}