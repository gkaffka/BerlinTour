package com.kaffka.berlintour.ui.adapters


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kaffka.berlintour.databinding.ReviewItemBinding
import com.kaffka.berlintour.domain.entity.Review
import com.kaffka.berlintour.ui.viewmodels.ReviewItemViewModel


class ReviewsAdapter(private val reviews: List<Review>) : RecyclerView.Adapter<ReviewsAdapter.ReviewItemViewHolder>() {

    override fun onBindViewHolder(holder: ReviewsAdapter.ReviewItemViewHolder, position: Int) =
            holder.bind(ReviewItemViewModel(reviews[position]))


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ReviewItemBinding.inflate(inflater, parent, false)
        return ReviewItemViewHolder(binding)
    }

    override fun getItemCount() = reviews.size

    inner class ReviewItemViewHolder(private val binding: ReviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(review: ReviewItemViewModel) {
            binding.viewmodel = review
            binding.executePendingBindings()
        }
    }
}