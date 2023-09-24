package com.the_chance.newswave.ui.features.see_all_news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.newswave.ui.components.BreakingNews
import com.the_chance.newswave.ui.components.RecommendedNews
import com.the_chance.newswave.ui.features.home.HomeUiState
import com.the_chance.newswave.ui.features.home.NewsViewModel
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8

@Composable
fun SeeAllNewsScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
){
    val state by newsViewModel.state.collectAsState()

//    Loading(state = state.isLoading)
//    ContentVisibility(state = state.showBreakingNews()) {
//        SeeAllBreakingNewsContent(state = state)
//    }

}

@Composable
fun SeeAllBreakingNewsContent(
    state: HomeUiState
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(space8),
        verticalArrangement = Arrangement.spacedBy(space8),
        contentPadding = PaddingValues(bottom = space16),
        columns = GridCells.Fixed(2)
    ) {
        item(span = { GridItemSpan(2) })
        {
            BreakingNews(news = state.news)
        }
    }
}

@Composable
fun SeeAllRecommendNewsContent(
    state: HomeUiState
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(space8),
        verticalArrangement = Arrangement.spacedBy(space8),
        contentPadding = PaddingValues(bottom = space16),
        columns = GridCells.Fixed(2)
    ) {
        item(span = { GridItemSpan(2) })
        {
            RecommendedNews(currentNews = state.currentNews)
        }
    }
}
