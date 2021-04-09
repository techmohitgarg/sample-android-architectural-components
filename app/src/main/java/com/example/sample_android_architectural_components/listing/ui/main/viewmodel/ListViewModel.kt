package com.example.sample_android_architectural_components.listing.ui.main.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_android_architectural_components.listing.data.model.Articles
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import com.example.sample_android_architectural_components.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _resultNewsList = MutableLiveData<Result<List<Articles>>>()

    var progressBarState: ObservableField<Boolean> = ObservableField(true)
    var recyclerViewState: ObservableField<Boolean> = ObservableField(false)

    val resultNewsList: LiveData<Result<List<Articles>>>
        get() = _resultNewsList

    fun fetchNewsData(country: String, apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _resultNewsList.postValue(Result.Loading)
                val response = newsRepository.getTopNews(country, apiKey)
                _resultNewsList.postValue(Result.Success(response.articles))
            } catch (e: Exception) {
                _resultNewsList.postValue(Result.Error(e.message))
            }
        }
    }

}