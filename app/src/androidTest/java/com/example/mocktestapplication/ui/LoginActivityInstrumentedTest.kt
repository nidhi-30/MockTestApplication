package com.example.mocktestapplication.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.mocktestapplication.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LoginActivityInstrumentedTest{

    @get:Rule
    val loginActivityActivityTestRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(LoginActivity::class.java)
    }

    @Test
    fun isActivityInView(){
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTitleText(){
        onView(withId(R.id.welcome_message)).check(matches(isDisplayed()))
        onView(withId(R.id.welcome_message)).check(matches(withText(R.string.welcome_message)))
    }


    @Test
    fun recyclerViewVisibility(){
        onView(withId(R.id.input_fields)).check(matches(isDisplayed()))
    }

    @Test
    fun buttonVisibility(){
        onView(withId(R.id.login_button)).check(matches(isDisplayed()))
        onView(withId(R.id.login_button)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

}