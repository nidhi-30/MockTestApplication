package com.example.mocktestapplication

import androidx.lifecycle.MutableLiveData
import java.util.regex.Pattern

object User {

    var userName : MutableLiveData<String> = MutableLiveData("")

    fun validateField(inputField: String) : Boolean{
        val regExp = "^([0-9]+[a-z]|[a-z]+[0-9])[a-z0-9]*"
        val pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE)
        return inputField.isNotEmpty() && pattern.matcher(inputField).matches()
    }

    fun setUsername(name : String){
        userName.postValue(name)
    }

    fun getUsername() : String? {
        return userName.value
    }

}