package com.example.mocktestapplication.model

import com.google.gson.annotations.SerializedName


data class MockResponse (
    @SerializedName("isSuccessful")
    var isSuccessful : Boolean,
    @SerializedName("username")
    var username : String
)