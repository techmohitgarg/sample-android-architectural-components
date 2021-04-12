package com.example.sample_android_architectural_components.network


interface NetworkProvider {

    fun <T : Any> getApiInstance(
        apiClass: Class<T>,
        baseUrl: String
    ): T
}