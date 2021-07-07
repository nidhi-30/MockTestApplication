package com.example.mocktestapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mocktestapplication.model.MockResponse
import com.example.mocktestapplication.network.MockService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel(private val mockService: MockService) : ViewModel() {

    private val disposable = CompositeDisposable()

    val mockResponse = MutableLiveData<MockResponse>()
    val mockError = MutableLiveData<String>()

    fun mockLogin(){
        mockLoginResponse()
    }

    private fun mockLoginResponse(){

        mockService.getMockResponse()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<MockResponse>(){
                override fun onSuccess(value: MockResponse?) {
                    mockResponse.postValue(value)
                    Log.d("Success",value.toString())
                }

                override fun onError(e: Throwable?) {
                    mockError.postValue(e?.message)
                    Log.d("Error",e.toString())
                }

            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}