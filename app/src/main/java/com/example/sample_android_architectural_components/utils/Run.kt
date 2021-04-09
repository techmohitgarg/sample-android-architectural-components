package com.example.sample_android_architectural_components.utils

import android.os.Handler
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 * Generic class for the handler postDelayed
 *
 * How to use :
 *
 * Run.after(1000, { print something useful etc.})
 */
class Run {
    companion object {
        fun after(delay: Long, process: () -> Unit) {
            Executors.newSingleThreadScheduledExecutor().schedule({
                process()
            }, delay, TimeUnit.SECONDS)
        }
    }
}