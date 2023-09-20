package com.the_chance.newswave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space6
import com.the_chance.newswave.ui.theme.space8
import com.the_chance.newswave.ui.theme.white
import com.the_chance.newswave.ui.components.modifier.overlayBottomToTop

@Composable
fun BreakingNewsCard(
//    news: NewsUiState,
    imageNewsUrl: List<Int>,
    title: List<String>,
    modifier: Modifier = Modifier,
    onClickShowMore: () -> Unit,
    ) {
    Column(
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
            items(imageNewsUrl.size) { index ->
                Card(
                    modifier = modifier
                        .width(150.dp)
                        .height(140.dp)
                        .clickable(onClick = {}),
                    shape = Shapes.medium
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Image(
                            painter = painterResource(id = imageNewsUrl[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.overlayBottomToTop().size(150.dp),
                        )
                        Text(
                            text = title[index],
                            style = MaterialTheme.typography.displaySmall,
                            color = white,
                            modifier = modifier.padding(space6)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ItemNewsCardPreview() {
    NewsWaveTheme {
        BreakingNewsCard(
            imageNewsUrl = listOf(
                R.drawable.image_onboarding,
                R.drawable.image_onboarding ,
                R.drawable.image_onboarding
            ),
            title = listOf(
                "Tragedy as 15-year-old",
                "girl dies after being pulled" ,
                "from the sea at a beach"
            ),
        ) {}
    }
}