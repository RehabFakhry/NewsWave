package com.the_chance.newswave.ui.features.signup

data class SignUpUiState(
    val loading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
//    val signup
)
