package com.kaffka.berlintour.ui.viewmodels

import android.view.View
import com.kaffka.berlintour.R
import com.kaffka.berlintour.application.ResourceProvider
import com.kaffka.berlintour.domain.entity.Review

class ReviewItemViewModel(private val review: Review) {

    val title = review.title
        get() = getStringIfNull(field, R.string.unknown_title)

    val author = review.author
        get() = getStringIfNull(field, R.string.unknown_author)

    val message = review.message
        get() = getStringIfNull(field, R.string.unknown_message)

    val date = review.date
        get() = getStringIfNull(field, R.string.unknown_date)

    val rating = review.rating

    val titleVisibility = getFieldVisibility(review.title)

    val messageVisibility = getFieldVisibility(review.message)

    private fun getStringIfNull(string: String?, resId: Int) =
            if (string.isNullOrBlank()) ResourceProvider.getString(resId) else string

    private fun getFieldVisibility(string: String?) =
            if (string.isNullOrBlank()) View.GONE else View.VISIBLE

}
