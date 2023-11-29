package com.matheuslima.utilities

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LoggerProviderImpl: LoggerProvider, LifecycleEventObserver {
    private var tag = ""
    override fun registerLifecycleOwner(tag: String, lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(this)
        this.tag = tag
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE -> Log.d(LOGGER_TAG, "$CREATED_TEXT $tag")
            Lifecycle.Event.ON_START -> Log.d(LOGGER_TAG, "$START_TEXT $tag")
            Lifecycle.Event.ON_RESUME -> Log.d(LOGGER_TAG, "$RESUME_TEXT $tag")
            Lifecycle.Event.ON_PAUSE -> Log.d(LOGGER_TAG, "$PAUSE_TEXT $tag")
            Lifecycle.Event.ON_STOP -> Log.d(LOGGER_TAG, "$STOP_TEXT $tag")
            Lifecycle.Event.ON_DESTROY -> Log.d(LOGGER_TAG, "$DESTROY_TEXT $tag")
            Lifecycle.Event.ON_ANY -> Log.d(LOGGER_TAG, "$ANY_TEXT $tag")
        }
    }

    private companion object {
        const val LOGGER_TAG = "LOGGER_PROVIDER"
        const val CREATED_TEXT = "Activity/Fragment/View created:"
        const val START_TEXT = "Activity/Fragment/View started:"
        const val RESUME_TEXT = "Activity/Fragment/View resumed:"
        const val PAUSE_TEXT = "Activity/Fragment/View paused:"
        const val STOP_TEXT = "Activity/Fragment/View stopped:"
        const val DESTROY_TEXT = "Activity/Fragment/View destroyed:"
        const val ANY_TEXT = "something happened with the Activity/Fragment/View:"
    }
}