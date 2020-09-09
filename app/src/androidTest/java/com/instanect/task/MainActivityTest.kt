package com.instanect.task

import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)

    public fun setUp(){
    }
    @Test
    public fun testActivityStarted() {
        Intents.init();
        intended(hasComponent(MainActivity::class.java.name))
        Intents.release();
    }

}