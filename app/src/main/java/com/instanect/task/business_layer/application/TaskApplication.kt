package com.instanect.task.business_layer.application

import android.app.Application
import com.instanect.task.business_layer.database.TaskDatabaseHelper
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
open class TaskApplication : Application() {
    @Inject
    lateinit var taskDatabaseHelper: TaskDatabaseHelper
}