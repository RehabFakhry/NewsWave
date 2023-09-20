package com.the_chance.newswave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.modifier.fullOverlay
import com.the_chance.newswave.ui.theme.fontSize14
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space4
import com.the_chance.newswave.ui.theme.space6
import com.the_chance.newswave.ui.theme.space8

@Composable
fun CardRecommendedNews(
    newsImage: List<Int>,
    newsTitle: List<String>,
    newsTime: List<String>,
    author: List<String>,
    modifier: Modifier = Modifier,
) {

    Column(
        verticalArrangement = Arrangement.spacedBy(space8),
    ) {
        ItemLabel(
            label = stringResource(R.string.recommended),
            modifier = modifier.padding(top = space16),
            onClickShowMore = {}
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(space8))
        {
            items(newsImage.size) { index ->

                Box(
                    modifier = modifier
                        .width(160.dp)
                        .height(184.dp)
                        .clip(RoundedCornerShape(topStart = space8, topEnd = space8))
                ) {
//        ImageNetwork(imageUrl = imageUrl, modifier = modifier.fillMaxSize())
                    Image(
                        painter = painterResource(id = newsImage[index]),
                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .fullOverlay()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = space8, end = space8),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        CustomChip(
                            state = true,
                            text = "Business",
                            width = 60.dp,
                            height = 28.dp,
                            onClick = {}
                        )
                    }

                    Box(
                        modifier = modifier
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
                                text = newsTitle[index],
                                fontSize = fontSize14,
                                maxLines = 1,
                                modifier = modifier.padding(vertical = space4, horizontal = space6),
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                            Text(
                                text = newsTime[index],
                                fontSize = fontSize14,
                                maxLines = 1,
                                modifier = modifier.padding(vertical = space4, horizontal = space6),
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                            Text(
                                text = author[index],
                                fontSize = fontSize14,
                                maxLines = 1,
                                modifier = modifier.padding(vertical = space4, horizontal = space6),
                                color = MaterialTheme.colorScheme.onBackground,

                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    CardRecommendedNews(
        newsImage = listOf(
            R.drawable.image_onboarding,
            R.drawable.image_onboarding,
            R.drawable.image_onboarding,
            R.drawable.image_onboarding
        ),
        newsTitle = listOf(
            "News headline News...  ",
            "News headline News...  ",
            "News headline News...  ",
            "News headline News...  ",
        ),
        newsTime = listOf(
            "2 hours ago",
            "5 hours ago",
            "6 hours ago",
            "7 hours ago",
        ),
        author = listOf(
            "josef",
            "josef",
            "josef",
            "josef",
        )

//        "https://upload.wikimedia.org/wikipedia/commons/1/13/Supermarkt.jpg",
    )
}