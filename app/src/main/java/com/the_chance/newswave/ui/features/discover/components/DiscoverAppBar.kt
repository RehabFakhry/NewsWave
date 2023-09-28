package com.the_chance.newswave.ui.features.discover.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8

@Composable
fun DiscoverAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space8)
    ) {
        Card(
            modifier = modifier
                .padding(top = space16)
                .align(Alignment.Top)
                .background(Color.Transparent),
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_logo),
                contentDescription = "logo image",
                modifier = Modifier
                    .size(48.dp)
            )
        }

        Column(
            modifier = modifier.wrapContentSize(),
        ) {
            Text(
                text = stringResource(id = R.string.discover),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = stringResource(R.string.news_from_all_around_the_world),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
            )
        }
    }
}