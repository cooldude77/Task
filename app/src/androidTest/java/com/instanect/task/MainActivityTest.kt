package com.instanect.task

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.instanect.task.business_layer.di.TaskModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(TaskModule::class)
@HiltAndroidTest
class MainActivityTest {
    @get:Rule
    var activityScenarioRule = HiltAndroidRule(this)

    @Before
    fun init() {
        activityScenarioRule.inject()
    }


    @Test
    fun testActivityStarted() {
        onView(withId(R.id.fab)).perform(click())
    }

}