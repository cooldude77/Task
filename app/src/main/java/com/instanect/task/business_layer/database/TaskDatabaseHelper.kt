package com.instanect.task.business_layer.database

import android.content.Context
import androidx.room.Room

class TaskDatabaseHelper(var context: Context) {

    fun getInstance(): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java, "task.db"
        ).build()
    }

}