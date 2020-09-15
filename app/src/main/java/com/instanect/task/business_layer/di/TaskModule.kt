package com.instanect.task.business_layer.di

import android.content.Context
import com.instanect.task.business_layer.database.TaskDatabaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class TaskModule {

    @Provides
    fun provideDatabaseHelper(@ApplicationContext applicationContext: Context): TaskDatabaseHelper {

        return TaskDatabaseHelper(applicationContext)
    }
}