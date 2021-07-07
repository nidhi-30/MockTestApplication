package com.example.mocktestapplication.ui

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mocktestapplication.viewmodel.LoginViewModel
import com.example.mocktestapplication.viewmodel.LoginViewModelFactory
import com.example.mocktestapplication.network.MockService
import com.example.mocktestapplication.User
import com.example.mocktestapplication.databinding.ActivityLoginBinding
import com.example.mocktestapplication.User.validateField
import com.example.mocktestapplication.adapters.InputFieldAdapter

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var viewModel: LoginViewModel
    private var mockService = MockService()

    private lateinit var adapter : InputFieldAdapter

    private lateinit var userName : String
    private lateinit var password : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, LoginViewModelFactory(mockService)).get(LoginViewModel::class.java)

        adapter = InputFieldAdapter(this)

        val inputFieldList = listOf("Username", "Password")
        adapter.setInputFields(inputFieldList)
        binding.inputFields.adapter = adapter

        binding.loginButton.setOnClickListener {

            adapter.getTextFields()

            userName = adapter.getInputFields()[0]
            password = adapter.getInputFields()[1]

            if(validateField(userName) && validateField(password)){

                User.setUsername(userName)

                viewModel.mockLogin()

                viewModel.mockResponse.observe(this, Observer {
                    Toast.makeText(this, "$it", Toast.LENGTH_LONG).show()
                })

                viewModel.mockError.observe(this, Observer {
                    Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                })

                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
            else{
                val dialog = AlertDialog.Builder(this)
                dialog.setTitle("Login Failed")
                dialog.setPositiveButton("OK", null)
                dialog.setMessage("Username and Password must contain at least a letter and a number")
                dialog.show()
            }
        }

    }

}