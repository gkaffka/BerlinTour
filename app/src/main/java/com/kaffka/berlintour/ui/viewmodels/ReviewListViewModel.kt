package com.kaffka.berlintour.ui.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kaffka.berlintour.data.remote.SortCriteria
import com.kaffka.berlintour.data.remote.SortDirection
import com.kaffka.berlintour.domain.entity.Review
import com.kaffka.berlintour.domain.repository.ReviewRepository

class ReviewListViewModel : ViewModel() {

    private val repository = ReviewRepository()
    var reviews: MutableLiveData<List<Review>> = MutableLiveData()
    var sortDirection = SortDirection.DESCENDING
    var sortCriteria = SortCriteria.DATE
    var rating: Int? = null

    private var reviewsAccumulator: MutableList<Review> = mutableListOf()

    fun loadReviews(page: Int) {
        repository.getReviewsFromRemote(page, reviews, reviewsAccumulator,
                rating = rating,
                sortCriteria = sortCriteria,
                sortDirection = sortDirection)
    }

    fun clearAccumulatedReviews() {
        reviewsAccumulator.clear()
    }
}