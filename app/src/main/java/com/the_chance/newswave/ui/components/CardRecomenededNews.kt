package com.the_chance.newswave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.ui.theme.fontSize12
import com.the_chance.newswave.ui.theme.fontSize14
import com.the_chance.newswave.ui.theme.space4
import com.the_chance.newswave.ui.theme.space8

@Composable
fun CardRecommendedNews(
    imageUrl: String,
    modifier: Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {

        ImageNetwork(imageUrl = imageUrl, modifier = modifier.fillMaxSize())

        Box(modifier = modifier) {
            Card(
                modifier = modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),

                ) {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(White)
                        .padding(vertical = space8, horizontal = space8),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "News headline News...  ",
                        textSize = fontSize14,
                    )
                    Text(
                        text = "4 hours ago",
                        textSize = fontSize12,
                        modifier.padding(vertical = space4)
                    )
                    Text(
                        text = "Author",
                        textSize = fontSize12
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCard() {
    CardRecommendedNews(
        "https://upload.wikimedia.org/wikipedia/commons/1/13/Supermarkt.jpg",
        modifier = Modifier
    )
}