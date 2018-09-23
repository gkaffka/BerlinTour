package com.kaffka.berlintour.domain.repository

import android.arch.lifecycle.MutableLiveData
import com.kaffka.berlintour.data.remote.*
import com.kaffka.berlintour.domain.entity.Review
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewRepository {

    fun getReviewsFromRemote(page: Int,
                             reviewList: MutableLiveData<List<Review>>,
                             reviewListAccumulator: MutableList<Review>,
                             count: Long = 15L,
                             rating: Int? = null,
                             sortDirection: SortDirection = SortDirection.DESCENDING,
                             sortCriteria: SortCriteria = SortCriteria.DATE,
                             tour: Tours = Tours.BERLIN_AIRPORT) {

        val call = ApiService.instance.getTourReviews(tour.location, tour.tour, count, page, rating,
                sortCriteria.value,
                sortDirection.value)

        call.enqueue(object : Callback<ReviewsListResponse> {
            override fun onFailure(call: Call<ReviewsListResponse>, t: Throwable) {
                reviewList.postValue(null)
            }

            override fun onResponse(call: Call<ReviewsListResponse>, response: Response<ReviewsListResponse>) {
                val reviewsPerPage = ServerToDomainMapper().transform(response.body())?.data
                reviewsPerPage?.let { reviewListAccumulator.addAll(it) }
                reviewList.postValue(reviewListAccumulator)
            }

        })
    }
}

