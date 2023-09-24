package com.the_chance.newswave.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.modifier.overlayBottomToTop
import com.the_chance.newswave.ui.features.home.NewsUiState
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.space12
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space6
import com.the_chance.newswave.ui.theme.space8
import com.the_chance.newswave.ui.theme.white

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
                contentDescription = "",
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
                    .padding(space6)
                    .align(Alignment.BottomStart)
            )
        }
    }
