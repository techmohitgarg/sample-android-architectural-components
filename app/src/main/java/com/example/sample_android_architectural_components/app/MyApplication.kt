package com.example.sample_android_architectural_components.app

import android.app.Application

public class MyApplication : Application() {

    init {
        instance_ = this
    }

    companion object {
        lateinit var instance_: MyApplication

        fun getInstance() = instance_
    }

    override fun onCreate() {
        super.onCreate()

    }
}