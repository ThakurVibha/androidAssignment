package com.example.onlinesaleaiassignment.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_data_table")
data class MathExpressionEntity(
    @PrimaryKey(autoGenerate = true)
    val expressionId:Int,
    val expressionValue: String
)
