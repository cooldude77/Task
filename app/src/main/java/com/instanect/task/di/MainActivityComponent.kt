package com.instanect.task.di

import com.instanect.task.application.TaskApplication
import dagger.Component

@Component(modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(app: TaskApplication)
}