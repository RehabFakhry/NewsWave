package com.the_chance.newswave.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.heightItemNewsCard
import com.the_chance.newswave.ui.theme.space6
import org.the_chance.honymart.ui.modifier.overlayBottomToTop

@Composable
fun BreakingNewsCard(
    imageNewsUrl: String,
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    ) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(heightItemNewsCard)
            .clickable(onClick = onClick),
        shape = Shapes.medium
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomStart
        ) {
            ImageNetwork(
                modifier = Modifier.overlayBottomToTop(),
                imageNewsUrl,
                )
            Text(
                title,
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = modifier.padding(space6)
            )
        }
    }
}

@Preview
@Composable
private fun ItemMarketCardPreview() {
    NewsWaveTheme {
        BreakingNewsCard(
            imageNewsUrl = "https://upload.wikimedia.org/wikipedia/commons/1/13/Supermarkt.jpg",
            title = "Tragedy as 15-year-old girl dies after being pulled from the sea at a beach"
        ) {}
    }
}