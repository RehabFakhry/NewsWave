package com.the_chance.ui.ui.features.discover.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.the_chance.ui.R
import com.the_chance.ui.ui.theme.space16

@Composable
fun DiscoverAppBar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        Card(
            modifier = modifier
                .padding(top = space16)
                .align(Alignment.Top),
            colors = CardDefaults.cardColors(Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_logo),
                contentDescription = "logo image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .background(Color.Transparent)
            )
        }

        Column(
            modifier = modifier.fillMaxWidth(),
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