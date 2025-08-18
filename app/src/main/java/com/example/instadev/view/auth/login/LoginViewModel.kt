package com.example.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState:StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String){
        _uiState.update { state ->
            state.copy(email = email,
                //isLoginEnable = isEmailValid(state.email) && isPasswordValid(state.password)
            )
        }
        verifyLogin()
    }

    fun onPasswordChange(password: String){
        _uiState.update {
            it.copy(password = password)
        }
        verifyLogin()
    }

    private fun verifyLogin(){
        val enabledLogin = isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnable = enabledLogin)
        }
    }

    private fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPasswordValid(password: String): Boolean = password.length >= 6
}

data class LoginUiState(
    val email:String = "",
    val password:String = "",
    val iLoading: Boolean = false,
    val isLoginEnable: Boolean = false
)

//sealed class MyUiState{
//    object Error
//    data class Success (val test:String)
//}