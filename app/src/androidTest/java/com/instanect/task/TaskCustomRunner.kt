package com.instanect.task

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

class TaskCustomRunner : AndroidJUnitRunner() {


    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, TaskTestApplication::class.java.name, context)
    }

}