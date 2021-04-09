package com.example.sample_android_architectural_components.listing.ui.main.callbacks

import com.example.sample_android_architectural_components.listing.data.model.Articles

interface ItemClickListener {
    fun onItemClicked(article: Articles)
}