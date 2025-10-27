package com.example.instadev.view.auth.register

import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onChangeMode(){
        _uiState.update {
            it.copy(isPhoneMode = !it.isPhoneMode, value = "")
        }
    }

    fun onRegisterChanged(value:String){
        _uiState.update { state ->
            val isEnabled = if(state.isPhoneMode){
                value.length>=9
            } else {
                Patterns.EMAIL_ADDRESS.matcher(value).matches()
            }
            state.copy(isRegisterEnabled = isEnabled, value = value)
        }
    }
}

data class RegisterUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isRegisterEnabled: Boolean = false
)



//sealed class RegisterUiState(val isbuttonEnabled: Boolean = false){
//    data class PhoneMode(val phone:String, val isPhoneButtonEnable: Boolean)
//    data class EmailMode(val email:String)
//}