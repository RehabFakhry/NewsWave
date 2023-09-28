package com.the_chance.newswave.ui.features.search.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.ui.components.ImageNetwork
import com.the_chance.newswave.ui.components.modifier.overlayBottomToTop
import com.the_chance.newswave.ui.theme.Shapes
import com.the_chance.newswave.ui.theme.space2
import com.the_chance.newswave.ui.theme.space8

@Composable
fun CardSearch(
    imageUrl: String,
    newsTitle: String,
    author: String,
    onClickCard: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(240.dp)
            .width(160.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClickCard() }
    ) {
        ImageNetwork(
            imageUrl = imageUrl,
            modifier = Modifier
                .clip(shape = Shapes.medium)
                .overlayBottomToTop()
                .size(240.dp),
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(start = space8, bottom = space8, end = space8),
            verticalArrangement = Arrangement.spacedBy(space2)
        ) {
            Text(
                text = newsTitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = author,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun SearchCardPreview() {
    CardSearch(
        imageUrl = "https://img.freepik.com/free-photo/mid-century-modern-living-room-interior-design-with-monstera-tree_53876-129804.jpg",
        newsTitle = "To Kill a Mockingbird",
        author = "josef",
        onClickCard = {}
    )
}