package com.kaffka.berlintour.BerlinTourMainScreen

import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.kaffka.berlintour.data.remote.SortCriteria
import com.kaffka.berlintour.data.remote.SortDirection
import com.kaffka.berlintour.robots.MainActivityRobot
import com.kaffka.berlintour.ui.activities.MainActivity
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class MainActivityTest {
    @get:Rule
    val mActivityTestRule = IntentsTestRule(MainActivity::class.java)

    private lateinit var robot: MainActivityRobot

    @Before
    fun setup() {
        robot = MainActivityRobot()
    }

    @Test
    fun clickedOrderByDateTest() {
        robot.clickOrderByDate()
        assertEquals(mActivityTestRule.activity.reviewsViewModel.sortCriteria, SortCriteria.DATE)
    }

    @Test
    fun clickedOrderByRatingTest() {
        robot.clickOrderByRating()
        assertEquals(mActivityTestRule.activity.reviewsViewModel.sortCriteria, SortCriteria.RATING)
    }

    @Test
    fun clickedOrderAscendingTest() {
        robot.clickOrderAscending()
        assertEquals(mActivityTestRule.activity.reviewsViewModel.sortDirection, SortDirection.ASCENDING)
    }

    @Test
    fun clickedOrderDescendingTest() {
        robot.clickOrderDescending()
        assertEquals(mActivityTestRule.activity.reviewsViewModel.sortDirection, SortDirection.DESCENDING)
    }

}