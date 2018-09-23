package com.kaffka.berlintour.application

import android.app.Application

class BerlinTourApplication : Application() {

    companion object {
        lateinit var instance: BerlinTourApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}