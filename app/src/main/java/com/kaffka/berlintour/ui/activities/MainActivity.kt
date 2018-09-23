package com.kaffka.berlintour.ui.activities


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.kaffka.berlintour.R
import com.kaffka.berlintour.data.remote.SortCriteria.DATE
import com.kaffka.berlintour.data.remote.SortCriteria.RATING
import com.kaffka.berlintour.data.remote.SortDirection.ASCENDING
import com.kaffka.berlintour.data.remote.SortDirection.DESCENDING
import com.kaffka.berlintour.domain.entity.Review
import com.kaffka.berlintour.ui.adapters.InfiniteScrollListener
import com.kaffka.berlintour.ui.adapters.ReviewsAdapter
import com.kaffka.berlintour.ui.viewmodels.ReviewListViewModel
import com.kaffka.berlintour.util.ConnectivityVerifier
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var infiniteScrollListener: InfiniteScrollListener
    lateinit var reviewsViewModel: ReviewListViewModel
    private val firstPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initInfiniteScroll()
        loadReviews(firstPage)
    }

    private fun initViewModel() {
        reviewsViewModel = ViewModelProviders.of(this).get(ReviewListViewModel::class.java)
        reviewsViewModel.reviews.observe(this, Observer { onReviewsLoaded(it) })
    }

    private fun initInfiniteScroll() {
        infiniteScrollListener = object : InfiniteScrollListener(recyclerview.layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int) = loadReviews(page)
        }
        recyclerview.addOnScrollListener(infiniteScrollListener)
    }

    private fun onReviewsLoaded(reviewList: List<Review>?) {
        progressbar.visibility = View.GONE
        reviewList ?: return
        recyclerview.swapAdapter(ReviewsAdapter(reviewList), false)
    }

    fun onOrderOptionsClicked(view: View) {
        when (view.id) {
            R.id.rb_asc -> reviewsViewModel.sortDirection = ASCENDING
            R.id.rb_desc -> reviewsViewModel.sortDirection = DESCENDING
            R.id.rb_date -> reviewsViewModel.sortCriteria = DATE
            R.id.rb_rating -> reviewsViewModel.sortCriteria = RATING
        }
        clearListAndResetPageCount()
    }

    private fun clearListAndResetPageCount() {
        infiniteScrollListener.resetCurrentPage()
        reviewsViewModel.clearAccumulatedReviews()
        recyclerview.adapter?.notifyDataSetChanged()
        loadReviews(firstPage)
    }

    private fun loadReviews(page: Int) {
        ConnectivityVerifier.executeIfConnected(this) {
            progressbar.visibility = View.VISIBLE
            reviewsViewModel.loadReviews(page)
        }
    }
}
