package com.the_chance.domain.usecase

import com.the_chance.domain.repository.AuthRepository
import javax.inject.Inject

class AuthenticationUseCase @Inject constructor(
    authRepository: AuthRepository,
) {
    fun loginUser(
        email: String,
        password: String
    ) {

    }

    fun signupUser(
        fullName: String,
        email: String,
        password: String,
    ) {
    }
}