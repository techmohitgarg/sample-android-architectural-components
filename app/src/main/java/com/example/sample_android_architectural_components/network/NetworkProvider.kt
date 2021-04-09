package com.example.sample_android_architectural_components.network


interface NetworkProvider {

    //Set up the default base URL value here
    fun <T : Any> getApiInstance(
        apiClass: Class<T>,
        baseUrl: String
    ): T
}