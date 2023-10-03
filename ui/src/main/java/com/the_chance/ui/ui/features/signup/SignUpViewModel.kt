package com.the_chance.newswave.ui.features.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
//    private val authRepository: AuthRepository
): ViewModel(), SignUpInteractionListener {
    private val _signupState = Channel<SignUpUiState>()
    val signupState = _signupState.receiveAsFlow()

//    fun signupUser(email: String, password: String) = viewModelScope.launch {
//        authRepository.signupUser(email, password).collect{ result ->
//            when(result){
//                is Response.Success ->
//                    _signupState.send(SignupUiState(isSuccess = "Logged in Successfully"))
//
//                is Response.Error ->
//                    _signupState.send(SignupUiState(isError = result.message))
//
//                is Response.Loading ->
//                    _signupState.send(SignupUiState(loading = true))
//            }
//        }
//    }

    override fun onClickSignup(email: String, password: String) {
        TODO("Not yet implemented")
    }
}