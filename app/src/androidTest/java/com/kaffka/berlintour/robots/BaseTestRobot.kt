package com.kaffka.berlintour.robots

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId

open class BaseTestRobot {

    fun clickButton(resId: Int): ViewInteraction = onView((withId(resId))).perform(ViewActions.click())
    fun isViewDisplayed(resId: Int): ViewInteraction = onView(withId(resId)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}