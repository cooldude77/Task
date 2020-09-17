package com.instanect.task

import android.content.Context
import com.instanect.task.business_layer.database.TaskDatabaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import org.mockito.Mockito

@Module
@InstallIn(ApplicationComponent::class)
class TaskTestModule {
    private val taskDatabaseHelper: TaskDatabaseHelper =
        Mockito.mock(TaskDatabaseHelper::class.java)

    @Provides
    fun provideDatabaseHelper(@ApplicationContext applicationContext: Context): TaskDatabaseHelper {
        return taskDatabaseHelper
    }
}