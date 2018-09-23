package com.kaffka.berlintour.robots

import com.kaffka.berlintour.R

class MainActivityRobot : BaseTestRobot() {
    fun clickOrderByDate() = apply { clickButton(R.id.rb_date) }
    fun clickOrderByRating() = apply { clickButton(R.id.rb_rating) }
    fun clickOrderAscending() = apply { clickButton(R.id.rb_asc) }
    fun clickOrderDescending() = apply { clickButton(R.id.rb_desc) }
}