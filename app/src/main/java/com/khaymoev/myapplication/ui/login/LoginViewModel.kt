package com.khaymoev.myapplication.ui.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val loginValidData: LiveData<Boolean> = savedStateHandle.getLiveData("validData")

    fun loginDataChanged(user: String, password: String) {
        if (user.isNotBlank() && password.isNotBlank()) {
            validateAuth(user, password)
        }
        else {
            savedStateHandle["loginForm"] = false
        }
    }

    private fun validateAuth(user: String, password: String) {
        when {
            !userValid(user) -> savedStateHandle["validData"] = false
            !passwordValid(password) -> savedStateHandle["validData"] = false
            else -> savedStateHandle["validData"] = true
        }
    }

    private fun userValid(user: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(user).matches()
    }

    private fun passwordValid(password: String): Boolean {
        return password.length >= 8
    }
}