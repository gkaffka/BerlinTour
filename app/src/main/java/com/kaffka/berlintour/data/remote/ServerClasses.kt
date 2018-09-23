package com.kaffka.berlintour.data.remote

data class ReviewItemResponse(val review_id: String,
                              val rating: Float,
                              val title: String?,
                              val message: String?,
                              val author: String?,
                              val foreignLanguage: Boolean,
                              val date: String?,
                              val languageCode: String?,
                              val traveler_type: String?,
                              val reviewerName: String?,
                              val reviewerCountry: String?)

data class ReviewsListResponse(val status: Boolean?,
                               val total_reviews_comments: Long,
                               val data: List<ReviewItemResponse>?)