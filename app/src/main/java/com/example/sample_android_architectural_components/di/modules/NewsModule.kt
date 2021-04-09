package com.example.sample_android_architectural_components.di.modules

import com.example.sample_android_architectural_components.listing.data.api.NewsApiServices
import com.example.sample_android_architectural_components.listing.data.api.NewsDataSource
import com.example.sample_android_architectural_components.listing.data.api.NewsDataSourceImp
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepositoryImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NewsModule {
    @Singleton
    @Provides
    fun provideNewsDataSource(newsApiServices: NewsApiServices): NewsDataSource =
        NewsDataSourceImp(newsApiServices)

    @Singleton
    @Provides
    fun provideNewsRepository(newsDataSource: NewsDataSource): NewsRepository =
        NewsRepositoryImp(newsDataSource)
}