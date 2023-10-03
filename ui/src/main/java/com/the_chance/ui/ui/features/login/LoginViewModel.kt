package com.the_chance.newswave.ui.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the_chance.domain.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
//    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginState = Channel<LoginUiState>()
    val loginState = _loginState.receiveAsFlow()

//    fun loginUser(email: String, password: String) = viewModelScope.launch {
//        authRepository.loginUser(email, password).collect{ result ->
//            when(result){
//                is Response.Success ->
//                    _loginState.send(LoginUiState(isSuccess = "Logged in Successfully"))
//
//                is Response.Error ->
//                    _loginState.send(LoginUiState(isError = result.message))
//
//                is Response.Loading ->
//                    _loginState.send(LoginUiState(loading = true))
//            }
//        }
//    }
}