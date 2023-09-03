package com.the_chance.newswave.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val state by homeViewModel.state.collectAsState()

    HomeContent(state = state, listener = homeViewModel)
}

@Composable
fun HomeContent(
    state: NewsArticleUiState,
    listener: HomeInteractionListener
) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (state.isError) {
            // Handle the error condition here, e.g., display an error message
            Text(
                text = "Error: ${state.error?.toString() ?: "unknown "}",
                color = Color.Red,
                fontSize = 20.sp
            )
        } else {
            state.news.forEach { news ->
                Text(
                    text = "Author: ${news.author}, Title: ${news.title}",
                    modifier = Modifier.padding(bottom = 8.dp),
                    fontSize = 16.sp
                )
            }
        }
    }
}