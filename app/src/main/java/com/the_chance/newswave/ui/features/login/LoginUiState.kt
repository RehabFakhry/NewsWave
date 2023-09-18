package com.the_chance.newswave.ui.features.login

data class LoginUiState(
    val loading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
