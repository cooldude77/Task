package com.instanect.task

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.instanect.task.business_layer.database.TaskDatabaseHelper
import com.instanect.task.business_layer.di.TaskModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@UninstallModules(TaskModule::class)
@HiltAndroidTest
class MainActivityTest {

    @Inject
    lateinit var taskDatabaseHelper: TaskDatabaseHelper

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    // @get:Rule(order = 1)
    // var scenarioRule = activityScenarioRule<MainActivity>()


    @Before
    fun init() {

        hiltRule.inject()
        val scenario = ActivityScenario.launch(MainActivity::class.java)

        //     activityScenarioRule.inject()
        //   val scenario = launchActivity<MyActivity>()

        //    val scenario: ActivityScenario<*> = rule.scenario

    }


    @Test
    fun testActivityStarted() {
        onView(withId(R.id.fab)).perform(click())
    }

}