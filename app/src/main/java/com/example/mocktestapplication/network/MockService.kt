package com.example.mocktestapplication.network

import com.example.mocktestapplication.model.MockResponse
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class MockService {

    private val api =  Retrofit.Builder()
        .client(OkHttpClient.Builder().addInterceptor(MockInterceptor()).build())
        .baseUrl("https://fireflysoftware.ca/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(MockApi::class.java)

    fun getMockResponse() : Single<MockResponse> {
        return api.mockLogin()
    }

}