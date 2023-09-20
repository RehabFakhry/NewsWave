package com.the_chance.newswave.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8

@Composable
fun CircularImageCard(
    images: List<Int>,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(space8),
    ) {
        ItemLabel(
            label = stringResource(R.string.world_news),
            modifier = modifier.padding(top = space16),
            onClickShowMore = {}
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(space8),
        ) {
            items(images.size) { index ->

                Card(
                    shape = CircleShape,
                    modifier = modifier
                        .size(90.dp),
                ) {
                    Image(
                        painter = painterResource(id = images[index]),
                        contentDescription = contentDescription,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CircularImageCardDemo() {
    val imageResources = listOf(
        R.drawable.image_autho,
        R.drawable.image_onboarding,
        R.drawable.image_onboarding
    )
    CircularImageCard(
        images = imageResources,
        contentDescription = "Circular Image Card"
    )
}