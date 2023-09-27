package com.the_chance.newswave.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.modifier.overlayBottomToTop
import com.the_chance.newswave.ui.features.discover.NewsArticleUiState
import com.the_chance.newswave.ui.features.home.NewsUiState
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.space12
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space2
import com.the_chance.newswave.ui.theme.space4
import com.the_chance.newswave.ui.theme.space6
import com.the_chance.newswave.ui.theme.space8
import com.the_chance.newswave.ui.theme.white


@SuppressLint("ModifierParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BreakingNews(
    news: List<NewsUiState>,
    onClickBreakingNewsCard: () -> Unit = {},
    onClickShowMore: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val limitedNews = news.take(6)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space8),
    ) {
        ItemLabel(
            label = stringResource(R.string.breaking_news),
            modifier = modifier
                .padding(top = space16),
            onClickShowMore = onClickShowMore
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(space8),
        ) {
            items(items = limitedNews) { news ->
                BreakingNewsCard(
                    modifier = Modifier.animateItemPlacement(),
                    imageNewsUrl = news.image,
                    title = news.title,
                    onClickNewsCard = onClickBreakingNewsCard
                )
            }
        }
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun BreakingNewsForDiscover(
    news: List<NewsArticleUiState>,
    onClickBreakingNewsCard: () -> Unit = {},
    modifier: Modifier = Modifier,
    ) {
    val limitedNews = news.take(5)

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space8),
        verticalArrangement = Arrangement.spacedBy(space8),
        contentPadding = PaddingValues(bottom = space16),
        columns = GridCells.Fixed(2)
    ) {
        items(items = limitedNews) { news ->
            BreakingNewsDiscover(
                modifier = modifier,
                imageNewsUrl = news.image,
                title = news.title,
                country = news.country,
                onClickNewsCard = onClickBreakingNewsCard
            )
        }
    }
}


@Composable
fun BreakingNewsCard(
    imageNewsUrl: String,
    title: String,
    onClickNewsCard: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(140.dp)
            .clip(shape = RoundedCornerShape(space12))
            .clickable { onClickNewsCard },
        contentAlignment = Alignment.BottomStart
    ) {
        ImageNetwork(
            imageUrl = imageNewsUrl,
            contentDescription = stringResource(R.string.news_image),
            modifier = Modifier
                .clip(shape = Shapes.medium)
                .overlayBottomToTop()
                .size(150.dp),
        )
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            color = white,
            maxLines = 2,
            overflow = TextOverflow.Visible,
            modifier = modifier
                .padding(space16)
        )
    }
}

@SuppressLint("ModifierParameter")
@Composable
fun BreakingNewsDiscover(
    imageNewsUrl: String,
    title: String,
    country: String ,
    onClickNewsCard: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(240.dp)
            .clip(shape = RoundedCornerShape(space8))
            .clickable { onClickNewsCard },
    ) {
        ImageNetwork(
            imageUrl = imageNewsUrl,
            contentDescription = stringResource(R.string.news_image),
            modifier = Modifier
                .clip(shape = Shapes.medium)
                .overlayBottomToTop()
                .size(240.dp),
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = space8)
                .align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(space2)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.displayLarge,
                color = white,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(space4),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_location),
                    contentDescription = stringResource(R.string.location_icon)
                )
                Text(
                    text = country,
                    style = MaterialTheme.typography.displaySmall,
                    color = white,
                    overflow = TextOverflow.Visible,
                    modifier = modifier.padding(bottom = space16)
                )
            }
        }
    }
}