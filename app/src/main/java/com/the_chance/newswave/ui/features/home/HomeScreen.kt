package com.the_chance.newswave.ui.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.BreakingNews
import com.the_chance.newswave.ui.components.ContentVisibility
import com.the_chance.newswave.ui.components.EventHandler
import com.the_chance.newswave.ui.components.Loading
import com.the_chance.newswave.ui.components.NewsPager
import com.the_chance.newswave.ui.components.RecommendedNews
import com.the_chance.newswave.ui.components.WorldNews
import com.the_chance.newswave.ui.components.NewsAppBar
import com.the_chance.newswave.ui.features.search.navigateToSearchScreen
import com.the_chance.newswave.ui.features.see_all_news.navigateToSeeAllNewsScreen
import com.the_chance.newswave.ui.theme.space16
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    homeViewModel: NewsViewModel = hiltViewModel()
) {
    val state by homeViewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)

    EventHandler(
        effects = homeViewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                HomeUiEffect.NavigateToSearchScreenEffect -> navController.navigateToSearchScreen()
                HomeUiEffect.NavigateToSeeAllNewsEffect -> navController.navigateToSeeAllNewsScreen()
            }
        })

    Loading(state = state.isLoading)
    ContentVisibility(state = state.showHome()) {
        HomeContent(state = state, pagerState = pagerState, listener = homeViewModel)
    }

    LaunchedEffect(key1 = state.news.isNotEmpty()) {
        while (true) {
            delay(2000)
            pagerState.animateScrollToPage(page = (pagerState.currentPage + 1) % 3)
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    listener: HomeInteractionListener,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier.padding(top = space16, bottom = space16)) {
        NewsAppBar(
            startIcon = R.drawable.image_logo,
            title = stringResource(id = R.string.home),
            endIcon = R.drawable.icon_search,
            onEndIconClick = listener::onClickSearchIcon
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 108.dp, start = space16, end = space16
            ),
        contentPadding = PaddingValues(bottom = space16)
    ) {
        item {
            NewsPager(
                news = state.shuffledNews,
                pagerState = pagerState,
                modifier = modifier
            )
        }
        item {
            WorldNews(
                worldNews = worldNewsImages,
                onClickShowMore = listener::onClickShowMore,
                onClickWorldNews = listener::onClickWorldNews
            )
        }
        item {
            BreakingNews(
                news = state.news,
                onClickBreakingNewsCard = listener::onClickBreakingNews,
                onClickShowMore = listener::onClickShowMore
            )
        }
        item {
            RecommendedNews(
                currentNews = state.currentNews,
                onClickRecommendedNewsCard = listener::onClickRecommendedNews,
                onClickShowMore = listener::onClickShowMore,
            )
        }
    }
}