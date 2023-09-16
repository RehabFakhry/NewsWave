package com.the_chance.domain.repository

interface AuthRepository {
    suspend fun loginUser(email: String, password: String)
    suspend fun signupUser(email: String, password: String)
    }