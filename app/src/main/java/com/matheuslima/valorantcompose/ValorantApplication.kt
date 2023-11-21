package com.matheuslima.valorantcompose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ValorantApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Valorant_onCreate")
    }

    companion object {
        const val TAG = "ValorantApplication"
    }
}