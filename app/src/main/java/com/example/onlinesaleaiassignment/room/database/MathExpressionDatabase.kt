package com.example.onlinesaleaiassignment.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onlinesaleaiassignment.room.entity.MathExpressionEntity
import com.example.onlinesaleaiassignment.room.dao.MathExpressionDao

@Database(entities = [MathExpressionEntity::class], version = 1, exportSchema = false)
abstract class MathExpressionDatabase:RoomDatabase() {
    abstract fun myDataDao(): MathExpressionDao

    companion object{
        @Volatile
        private var INSTANCE: MathExpressionDatabase? = null

        fun getDatabase(context: Context): MathExpressionDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        MathExpressionDatabase::class.java,
                        "mathExpressionDatabase")
                        .build()
                }
            }
            return INSTANCE!!
        }}

}