package com.kaffka.berlintour.ui.viewmodels

import android.view.View
import com.kaffka.berlintour.domain.entity.Review
import org.junit.Assert.assertTrue
import org.junit.Test

class ReviewItemViewModelTest {

    private lateinit var reviewItemViewModel: ReviewItemViewModel

    @Test
    fun titleVisibilityTest() {
        reviewItemViewModel = ReviewItemViewModel(getMockedReview(title = null))
        assertTrue(reviewItemViewModel.titleVisibility == View.GONE)
    }

    @Test
    fun messageVisibilityTest() {
        reviewItemViewModel = ReviewItemViewModel(getMockedReview(message = null))
        assertTrue(reviewItemViewModel.messageVisibility == View.GONE)
    }

    private fun getMockedReview(id: String = "id",
                                rating: Float = 3.0f,
                                title: String? = "title",
                                message: String? = "message",
                                author: String? = "author",
                                foreignLanguage: Boolean = false,
                                date: String? = "date",
                                languageCode: String? = "en",
                                travelerType: String? = "friends",
                                reviewerName: String? = "name",
                                reviewerCountry: String? = "country") = Review(id,
            rating,
            title,
            message,
            author,
            foreignLanguage,
            date,
            languageCode,
            travelerType,
            reviewerName,
            reviewerCountry)
}