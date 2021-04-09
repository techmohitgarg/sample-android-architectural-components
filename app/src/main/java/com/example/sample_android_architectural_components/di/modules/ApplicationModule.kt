package com.example.sample_android_architectural_components.di.modules

import com.example.sample_android_architectural_components.utils.Util
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideUtil(): Util = Util()

}