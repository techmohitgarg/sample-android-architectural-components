package com.example.sample_android_architectural_components.utils

class Util {
    var TAG = Util::class.java.name

    public fun getArticleID(url: String): String {
        return url.replace("/", "-")
    }

}