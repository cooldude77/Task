package com.instanect.task.di

import com.instanect.task.MainActivity
import dagger.Component

@Component(modules = [TestAppModule::class])
interface TestAppComponent : AppComponent {
    fun inject(app: TestApplication)
    override fun inject(mainActivity: MainActivity)
}