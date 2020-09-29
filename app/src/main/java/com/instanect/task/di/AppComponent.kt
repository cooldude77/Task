package com.instanect.task.di

import com.instanect.task.MainActivity
import com.instanect.task.application.TaskApplication
import dagger.Component

@Component(modules = [MainActivityModule::class])
interface AppComponent {

    fun inject(app: TaskApplication)
    fun inject(mainActivity: MainActivity)
}