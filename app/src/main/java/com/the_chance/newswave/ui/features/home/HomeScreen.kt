package com.the_chance.newswave.ui.features.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.BreakingNewsCard
import com.the_chance.newswave.ui.components.CardRecommendedNews
import com.the_chance.newswave.ui.components.CircularImageCard
import com.the_chance.newswave.ui.components.ImageNetwork
import com.the_chance.newswave.ui.components.HorizontalPagerIndicator
import com.the_chance.newswave.ui.components.modifier.NewsAppBar
import com.the_chance.newswave.ui.features.search.navigateToSearchScreen
import com.the_chance.newswave.ui.navigation.LocalNavigationProvider
import com.the_chance.newswave.ui.theme.black16
import com.the_chance.newswave.ui.theme.heightItemNewsCard
import com.the_chance.newswave.ui.theme.space12
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space24
import com.the_chance.newswave.ui.theme.space4

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val state by homeViewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)

    HomeContent(state = state, pagerState = pagerState, listener = homeViewModel)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    state: NewsArticleUiState,
    pagerState: PagerState,
    listener: HomeInteractionListener
) {

    val navController = LocalNavigationProvider.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(space16),
        contentPadding = PaddingValues(bottom = space16)
    ) {
        item {
            NewsAppBar(
                startIcon = R.drawable.image_logo,
                title = stringResource(id = R.string.home),
                endIcon = R.drawable.icon_search,
                { navController.navigateToSearchScreen() }
            )
        }
        item {
            NewsPager(
                news = state.shuffledNews,
                pagerState = pagerState
            )
        }
        item {
            CircularImageCard(
                images = listOf(
                    R.drawable.image_autho,
                    R.drawable.image_onboarding,
                    R.drawable.image_onboarding
                ),
                contentDescription = "Circular Image Card"
            )
        }

        val imageNewsUrl = listOf(
            R.drawable.image_onboarding,
            R.drawable.image_onboarding,
            R.drawable.image_onboarding
        )
        val title = listOf(
            "Tragedy as 15-year-old",
            "girl dies after being pulled",
            "from the sea at a beach"
        )

        item {
            BreakingNewsCard(
                imageNewsUrl = imageNewsUrl,
                title = title
//                    news = news,
            ) {}
        }

        val newsImage = listOf(
            R.drawable.image_onboarding,
            R.drawable.image_onboarding,
            R.drawable.image_onboarding,
            R.drawable.image_onboarding
        )
        val newsTitle = listOf(
            "News headline News...  ",
            "News headline News...  ",
            "News headline News...  ",
            "News headline News...  ",
        )
        val newsTime = listOf(
            "2 hours ago",
            "5 hours ago",
            "6 hours ago",
            "7 hours ago",
        )
        val author = listOf(
            "josef",
            "josef",
            "josef",
            "josef",
        )

        item {
            CardRecommendedNews(
                newsImage = newsImage,
                newsTitle = newsTitle,
                newsTime = newsTime,
                author = author,
            )
        }
    }
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun NewsPager(
    news: List<NewsUiState>,
    pagerState: PagerState,
//    onClickPagerItem: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space16),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            contentPadding = PaddingValues(horizontal = space12),
            pageCount = news.size,
            state = pagerState,
        ) {
            ImageNetwork(
                imageUrl = news[it].image,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space4)
                    .clip(shape = RoundedCornerShape(space24))
                    .background(black16)
                    .height(heightItemNewsCard)
//                    .clickable(onClick = { }),
            )
        }
        HorizontalPagerIndicator(
            itemCount = if (news.size > 3) 3 else news.size,
            selectedPage = pagerState.currentPage,
        )
    }
}

//    state: NewsArticleUiState,
//    listener: HomeInteractionListener
//) {
//    LazyColumn(modifier = Modifier.padding(16.dp)) {
//        item {
////            if (state.isError) {
////                // Handle the error condition here, e.g., display an error message
////                Text(
////                    text = "Error: ${state.error?.toString() ?: "unknown "}",
////                    color = Color.Red,
////                    fontSize = 20.sp
////                )
////            } else {
////                state.news.forEach { news ->
////                    Text(
////                        text = "Author: ${news.author}, Title: ${news.title}",
////                        modifier = Modifier.padding(bottom = 8.dp),
////                        fontSize = 16.sp
////                    )
////                }
////            }
//
//
//        }
//    }
//}