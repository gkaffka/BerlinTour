package com.kaffka.berlintour.application

import android.content.Context
import android.support.annotation.StringRes

object ResourceProvider {
    fun getString(@StringRes resId: Int, context: Context = BerlinTourApplication.instance): String = context.getString(resId)
}
