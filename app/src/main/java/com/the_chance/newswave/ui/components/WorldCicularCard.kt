package com.the_chance.newswave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.space8

@Composable
fun WorldNews(
    worldNews: List<Int>,
    onClickShowMore: () -> Unit,
    onClickWorldNews: () -> Unit,
    modifier: Modifier = Modifier
) {
    val limitedNews = worldNews.take(6)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space8),
    ) {
        ItemLabel(
            label = stringResource(R.string.worldnews),
            onClickShowMore = onClickShowMore
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(space8),
        ) {
            items(items = limitedNews) { worldNews ->
                WorldNewsCard(
                    images = worldNews,
                    onClickWorldNewsCard = onClickWorldNews
                )
            }
        }
    }
}


@Composable
fun WorldNewsCard(
    images: Int,
    contentDescription: String = "",
    onClickWorldNewsCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = CircleShape,
        modifier = modifier
            .size(77.dp)
            .clickable { onClickWorldNewsCard },
    ) {
        Image(
            painter = painterResource(id = images),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}