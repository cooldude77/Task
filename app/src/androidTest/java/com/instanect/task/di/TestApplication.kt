package com.instanect.task.di

import com.instanect.task.application.TaskApplication

class TestApplication : TaskApplication() {
    override fun onCreate() {
        super.onCreate()
        DaggerTestAppComponent.builder().testAppModule(TestAppModule()).build().inject(this)
    }
}