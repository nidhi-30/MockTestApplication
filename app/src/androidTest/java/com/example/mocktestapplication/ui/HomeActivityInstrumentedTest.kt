package com.example.mocktestapplication.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.mocktestapplication.R
import com.example.mocktestapplication.User
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityInstrumentedTest {

    @get:Rule
    val homeActivityActivityTestRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun activityLaunchesSuccessfully() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun isActivityInView(){
        onView(withId(R.id.home)).check(matches(isDisplayed()))
    }

    @Test
    fun visibilityTextViews(){
        onView(withId(R.id.welcome_back)).check(matches(isDisplayed()))
        onView(withId(R.id.welcome_back)).check(matches(withText(R.string.welcome_back)))
        onView(withId(R.id.username_text)).check(matches(withText(User.getUsername())))
        onView(withId(R.id.username_text)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

}