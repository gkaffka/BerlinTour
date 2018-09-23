package com.kaffka.berlintour.data.remote

import com.kaffka.berlintour.domain.entity.Review
import com.kaffka.berlintour.domain.entity.ReviewList

class ServerToDomainMapper {
    private fun transform(reviewItemResponse: ReviewItemResponse) =
            reviewItemResponse.let {
                Review(it.review_id,
                        it.rating,
                        it.title,
                        it.message,
                        it.author,
                        it.foreignLanguage,
                        it.date,
                        it.languageCode,
                        it.traveler_type,
                        it.reviewerName,
                        it.reviewerCountry)
            }

    fun transform(reviewsListResponse: ReviewsListResponse?) =
            reviewsListResponse?.let {
                ReviewList(it.total_reviews_comments, it.data?.map { transform(it) })
            }
}