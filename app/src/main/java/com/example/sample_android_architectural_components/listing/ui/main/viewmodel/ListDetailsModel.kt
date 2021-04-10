package com.example.sample_android_architectural_components.listing.ui.main.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_android_architectural_components.listing.data.model.Articles
import com.example.sample_android_architectural_components.listing.data.model.LikesCommentsApiResponse
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import com.example.sample_android_architectural_components.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.http.Url


class ListDetailsModel(private val newsRepository: NewsRepository) : ViewModel() {

    var likes: ObservableField<Int> = ObservableField(0)
    var comments: ObservableField<Int> = ObservableField(0)

    fun fetchData(urlLikes: String, urlComments: String) {
        viewModelScope.launch(Dispatchers.IO) {
            coroutineScope {
                try {
                    likes.set(newsRepository.getLikes(urlLikes).likes)
                } catch (e: Exception) {
                    likes.set(0)
                }

                try {
                    comments.set(newsRepository.getComments(urlComments).comments)
                } catch (e: Exception) {
                    comments.set(0)
                }
            }
        }
    }
}