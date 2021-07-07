package com.example.mocktestapplication.network

import com.example.mocktestapplication.model.MockResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MockApi {

    @GET("login/")
    fun mockLogin() : Single<MockResponse>

}