package com.kaffka.berlintour.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.getyourguide.com"

object RetrofitProvider {

    val retrofit: Retrofit = retrofitProvider()

    private fun retrofitProvider() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

