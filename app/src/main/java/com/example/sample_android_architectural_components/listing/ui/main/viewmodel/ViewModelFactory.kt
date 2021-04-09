package com.example.sample_android_architectural_components.listing.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import javax.inject.Inject


class ViewModelFactory @Inject constructor(private val newsRepository: NewsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(newsRepository) as T
        }
        if (modelClass.isAssignableFrom(ListDetailsModel::class.java)) {
            return ListDetailsModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}