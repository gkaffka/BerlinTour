package com.kaffka.berlintour.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast
import com.kaffka.berlintour.R
import com.kaffka.berlintour.application.BerlinTourApplication


object ConnectivityVerifier {
    private fun isConnected(context: Context = BerlinTourApplication.instance): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnected == true
    }

    private fun showNoInternetAvailableToast(context: Context) =
            Toast.makeText(context, R.string.no_internet, Toast.LENGTH_LONG).show()

    fun executeIfConnected(context: Context, showToast: Boolean = true, block: () -> Unit) {
        if (isConnected(context)) block()
        else if (showToast) showNoInternetAvailableToast(context)
    }
}