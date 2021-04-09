package com.example.sample_android_architectural_components.di.modules

import com.example.sample_android_architectural_components.listing.data.api.NewsApiServices
import com.example.sample_android_architectural_components.network.NetWorkConfigurations
import com.example.sample_android_architectural_components.network.NetworkProvider
import com.example.sample_android_architectural_components.network.NetworkProviderImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetWorkModule {
    @Singleton
    @Provides
    fun provideNetworkProvider(): NetworkProvider = NetworkProviderImp()

    @Singleton
    @Provides
    fun provideApiService(networkProvider: NetworkProvider): NewsApiServices =
        networkProvider.getApiInstance(NewsApiServices::class.java, NetWorkConfigurations.BASE_URL)
}