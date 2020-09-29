package com.instanect.task.di

import android.content.Context
import androidx.room.Room
import com.instanect.task.business_layer.database.TaskDatabase
import dagger.Module

@Module
class MainActivityModule(var context: Context) {
    fun provideTaskDatabase(): TaskDatabase {
        return Room.databaseBuilder(
            context,
            TaskDatabase::class.java, "task.db"
        ).build()

    }

}