package com.the_chance.ui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.the_chance.newswave.ui.components.modifier.fullOverlay
import com.the_chance.ui.R
import com.the_chance.ui.ui.features.home.NewsUiState
import com.the_chance.ui.ui.theme.fontSize14
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space4
import com.the_chance.ui.ui.theme.space6
import com.the_chance.ui.ui.theme.space8

@Composable
fun RecommendedNews(
    recommendedNews: List<NewsUiState>,
    onClickRecommendedNewsCard: () -> Unit = {},
    onClickShowMore: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val limitedNews = recommendedNews.take(5)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space8),
    ) {
        ItemLabel(
            label = stringResource(R.string.recommended),
            modifier = modifier.padding(top = space16),
            onClickShowMore = onClickShowMore
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(space8)
        ) {
            items(limitedNews) { news ->
                RecommendedNewsCard(
                    modifier = modifier,
                    newsImage = news.image,
                    newsTitle = news.title,
                    newsTime = news.publishedAt,
                    newsCategory = news.category,
                    author = news.author,
                    onClickRecommendedNewsCard = onClickRecommendedNewsCard
                )
            }
        }
    }
}


@Composable
fun RecommendedNewsCard(
    newsImage: String,
    newsTitle: String,
    newsTime: String,
    author: String,
    newsCategory: String,
    onClickRecommendedNewsCard: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .width(160.dp)
            .height(184.dp)
            .clip(RoundedCornerShape(topStart = space8, topEnd = space8))
            .clickable { onClickRecommendedNewsCard() }
    ) {
        ImageNetwork(
            imageUrl = newsImage,
            modifier = modifier
                .fillMaxSize()
                .fullOverlay()
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = space8, end = space8),
            contentAlignment = Alignment.TopEnd
        ) {
            CategoryChip(text = newsCategory)
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = space8, topEnd = space8)),
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(MaterialTheme.colorScheme.onTertiary),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = newsTitle,
                    fontSize = fontSize14,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.padding(
                        top = space6, bottom = space4, start = space4, end = space4
                    ),
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = newsTime,
                    fontSize = fontSize14,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.padding(horizontal = space4),
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = author,
                    fontSize = fontSize14,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.padding(vertical = space4, horizontal = space4),
                    color = MaterialTheme.colorScheme.onBackground,
                    )
            }
        }
    }
}