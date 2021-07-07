package com.example.mocktestapplication.network

import com.example.mocktestapplication.BuildConfig
import com.example.mocktestapplication.User
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull

class MockInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if(BuildConfig.DEBUG){
            val uri = chain.request().url.toUri().toString()
            val responseString = when{
                uri.endsWith("login/") ->
                    """
                        {"isSuccessful" : "true", "username" : "${User.getUsername()}"}
                    """
                else ->
                    ""
            }
            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                        "application/json".toMediaTypeOrNull(),
                        responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        }
        else{
            throw IllegalAccessError("MockInterceptor is only meant for Testing Purposes and bound to be used only with DEBUG mode")
        }
    }
}