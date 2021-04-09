package com.example.sample_android_architectural_components.di.component

import com.example.sample_android_architectural_components.di.modules.ApplicationModule
import com.example.sample_android_architectural_components.di.modules.NetWorkModule
import com.example.sample_android_architectural_components.di.modules.NewsModule
import com.example.sample_android_architectural_components.listing.ui.main.view.ListActivity
import com.example.sample_android_architectural_components.listing.ui.main.view.ListItemDetailsActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetWorkModule::class, NewsModule::class, ApplicationModule::class])
interface ApplicationComponent {
    fun inject(listActivity: ListActivity)
    fun inject(listActivity: ListItemDetailsActivity)

}