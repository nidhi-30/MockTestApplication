package com.example.mocktestapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mocktestapplication.network.MockService

class LoginViewModelFactory constructor(private val mockService: MockService) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            LoginViewModel(this.mockService) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}