package com.instanect.task.di

import com.instanect.task.business_layer.database.TaskDatabase
import dagger.Module
import dagger.Provides
import org.mockito.Mockito

@Module
class TestAppModule {
    var taskDatabase: TaskDatabase = Mockito.mock(TaskDatabase::class.java)

    @Provides
    fun provideTaskDatabase(): TaskDatabase {

        return taskDatabase
    }

}