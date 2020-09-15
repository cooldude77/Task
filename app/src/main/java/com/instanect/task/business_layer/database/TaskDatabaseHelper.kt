package com.instanect.task.business_layer.database

import android.content.Context
import androidx.room.Room

class TaskDatabaseHelper(private val applicationContext: Context) {


    fun getDatabase(): TaskDatabase {
        return Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java, "task.db"
        ).build()
    }
}