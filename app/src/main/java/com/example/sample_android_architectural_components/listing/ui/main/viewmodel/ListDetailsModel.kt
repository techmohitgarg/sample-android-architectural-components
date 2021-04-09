package com.example.sample_android_architectural_components.listing.ui.main.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_android_architectural_components.listing.data.model.Articles
import com.example.sample_android_architectural_components.listing.data.repository.NewsRepository
import com.example.sample_android_architectural_components.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.Url


class ListDetailsModel(private val newsRepository: NewsRepository) : ViewModel() {

    var likes: ObservableField<String> = ObservableField("Likes 0")
    var comments: ObservableField<String> = ObservableField("Comment 0")

    fun fetchLikesData(urlLikes: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //likes.set("Likes : ${newsRepository.getLikes(urlLikes).likes}")
            } catch (e: Exception) {
                likes.set("Likes 0")
            }
        }
    }

    fun fetchCommentData(urlComments: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // comments.set("Comments : ${newsRepository.getComments(urlComments).comments}")
            } catch (e: Exception) {
                comments.set("Comments 0")
            }
        }
    }
}