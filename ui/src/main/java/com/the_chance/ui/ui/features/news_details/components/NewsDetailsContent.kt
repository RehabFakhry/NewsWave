package com.the_chance.ui.ui.features.news_details.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.ui.ui.theme.fontSize14
import com.the_chance.ui.ui.theme.fontSize16
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space4
import com.the_chance.ui.ui.theme.space56
import com.the_chance.ui.ui.theme.space8
import com.the_chance.ui.ui.theme.white
import com.the_chance.ui.R
import com.the_chance.ui.ui.components.CategoryChip

@Composable
fun DetailsContent(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_onboarding),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = space16, start = space16, end = space16),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(40.dp)
                    .clickable {},
                contentAlignment = Alignment.TopStart,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back_colored),
                    contentDescription = "colored back icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier.align(Alignment.Center)
                )
            }

            Box(
                modifier = modifier
                    .clip(CircleShape)
                    .background(Color.White)
                    .size(40.dp)
                    .clickable { },
                contentAlignment = Alignment.TopEnd
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_colord_saved),
                    contentDescription = "colored saved icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier.align(Alignment.Center)
                )
            }
        }

            Column(
                modifier = modifier.padding(start = space16, bottom = space56).align(Alignment.CenterStart),
                verticalArrangement = Arrangement.spacedBy(space8)
            ) {
                CategoryChip(text = "general")

                Text(
                    text = "newsTitle",
                    fontSize = fontSize14,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier,
                    color = white,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(space4),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    androidx.compose.material.Icon(
                        painter = painterResource(id = R.drawable.icon_location),
                        contentDescription = stringResource(R.string.location_icon)
                    )
                    Text(
                        text = "country",
                        fontSize = fontSize16,
                        color = white,
                        modifier = modifier
                    )
                }
            }


        Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(topStart = space16, topEnd = space16))
                .background(MaterialTheme.colorScheme.onTertiary),
        ) {
            Column(
                modifier = modifier.padding(space16)
            ) {
                Text(
                    text = "newsDescription",
                    fontSize = fontSize14,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = "newsSource",
                    fontSize = fontSize14,
                    maxLines = 1,
                    modifier = modifier.padding(horizontal = space4),
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    text = "newsUrl",
                    fontSize = fontSize14,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.padding(vertical = space4, horizontal = space4),
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsDetails() {
    DetailsContent()
}