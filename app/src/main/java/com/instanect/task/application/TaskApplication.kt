package com.instanect.task.application

import android.app.Application
import com.instanect.task.di.AppComponent
import com.instanect.task.di.DaggerAppComponent
import com.instanect.task.di.MainActivityModule

open class TaskApplication : Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .mainActivityModule(MainActivityModule(applicationContext))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}