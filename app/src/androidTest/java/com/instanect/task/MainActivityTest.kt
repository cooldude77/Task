package com.instanect.task

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.instanect.task.business_layer.database.TaskDatabase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Inject
    lateinit var taskDatabase: TaskDatabase

    fun setUp() {
    }

    @Test
    fun testActivityStarted() {
        onView(withId(R.id.fab)).perform(click())
    }

}