package com.the_chance.newswave.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import com.the_chance.newswave.ui.features.home.NewsUiState
import com.the_chance.newswave.ui.theme.black16
import com.the_chance.newswave.ui.theme.heightItemNewsCard
import com.the_chance.newswave.ui.theme.space12
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space20
import com.the_chance.newswave.ui.theme.space24
import com.the_chance.newswave.ui.theme.space4
import com.the_chance.newswave.ui.theme.space6
import com.the_chance.newswave.ui.theme.space8


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun NewsPager(
    news: List<NewsUiState>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(top = space8),
        verticalArrangement = Arrangement.spacedBy(space8),
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
            )
        }
        HorizontalPagerIndicator(
            itemCount = if (news.size > 3) 3 else news.size,
            selectedPage = pagerState.currentPage,
        )
    }
}

@Composable
fun HorizontalPagerIndicator(
    itemCount: Int,
    selectedPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until itemCount) {
            PagerIndicatorItem(selected = i == selectedPage)
            Spacer(modifier = Modifier.width(space8))
        }
    }
}

@Composable
fun PagerIndicatorItem(selected: Boolean) {
    val color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.outlineVariant
    val width = if (selected) space20 else space12
    val height = space6
    val cornerRadius = space4

    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .background(color, shape = RoundedCornerShape(cornerRadius))
    )
}