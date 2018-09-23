package com.kaffka.berlintour.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers("User-agent: GetYourGuide")
    @GET("{location}/{tour}/reviews.json")
    fun getTourReviews(
            @Path("location") location: String,
            @Path("tour") tour: String,
            @Query("count") count: Long,
            @Query("page") page: Int,
            @Query("rating") rating: Int?,
            @Query("sortBy") sortBy: String?,
            @Query("direction") direction: String?): Call<ReviewsListResponse>

    companion object {
        val instance: ApiService = create()
        private fun create() = RetrofitProvider.retrofit.create(ApiService::class.java)
    }
}

enum class SortDirection(val value: String) { ASCENDING("asc"), DESCENDING("desc") }

enum class SortCriteria(val value: String) { DATE("date_of_review"), RATING("rating") }

enum class Tours(val location: String, val tour: String) {
    BERLIN_AIRPORT("berlin-l17", "tempelhof-2-hour-airport-history-tour-berlin-airlift-more-t23776")
}