package com.instanect.task

import android.content.Context
import com.instanect.task.business_layer.database.TaskDatabase
import com.instanect.task.business_layer.database.TaskDatabaseHelper
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import org.mockito.Mockito

@Module
@InstallIn(ApplicationComponent::class)
class TaskTestModule {
    val taskDatabase = mock<TaskDatabase>(defaultAnswer = Mockito.RETURNS_DEEP_STUBS)
    val taskDatabaseHelper = mock<TaskDatabaseHelper>()

    init {
        whenever(taskDatabaseHelper.getDatabase()).thenReturn(taskDatabase)
    }

    @Provides
    fun provideDatabaseHelper(@ApplicationContext applicationContext: Context): TaskDatabaseHelper {
        return taskDatabaseHelper
    }
}