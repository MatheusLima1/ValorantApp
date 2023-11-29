package com.matheuslima.utilities

import androidx.lifecycle.LifecycleOwner

interface LoggerProvider {
    fun registerLifecycleOwner(tag: String, lifecycleOwner: LifecycleOwner)
}