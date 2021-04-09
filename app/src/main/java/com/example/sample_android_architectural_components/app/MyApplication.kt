package com.example.sample_android_architectural_components.app

import android.app.Application
import com.example.sample_android_architectural_components.di.component.ApplicationComponent
import com.example.sample_android_architectural_components.di.component.DaggerApplicationComponent
import com.example.sample_android_architectural_components.di.modules.ApplicationModule
import com.example.sample_android_architectural_components.di.modules.NetWorkModule
import com.example.sample_android_architectural_components.di.modules.NewsModule

class MyApplication : Application() {
    private lateinit var mAppComponent: ApplicationComponent

    init {
        instance_ = this
    }

    companion object {
        lateinit var instance_: MyApplication

        fun getInstance() = instance_
    }

    override fun onCreate() {
        super.onCreate()

        mAppComponent =
            DaggerApplicationComponent.builder()
                .netWorkModule(NetWorkModule())
                .newsModule(NewsModule())
                .applicationModule(ApplicationModule())
                .build()
    }

    fun getAppComponent() = mAppComponent
}