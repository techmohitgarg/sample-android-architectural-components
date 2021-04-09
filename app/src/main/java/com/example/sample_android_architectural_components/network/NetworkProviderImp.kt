package com.example.sample_android_architectural_components.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class NetworkProviderImp : NetworkProvider {
    private var okHttpClient: OkHttpClient? = null
    override fun <T : Any> getApiInstance(apiClass: Class<T>, baseUrl: String): T {
        return buildApi(apiClass, baseUrl)
    }

    private fun <T : Any> buildApi(apiClass: Class<T>, baseUrl: String): T {
        val retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(apiClass) as T
    }


    private fun getOkHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            val builder = OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(
                    30,
                    TimeUnit.SECONDS
                )
                .readTimeout(30, TimeUnit.SECONDS)


            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)

            okHttpClient = builder.build()
        }
        return okHttpClient!!
    }
}