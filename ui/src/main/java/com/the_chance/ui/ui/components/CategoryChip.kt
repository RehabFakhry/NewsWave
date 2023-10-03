package com.the_chance.ui.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.ui.ui.theme.NewsWaveTheme
import com.the_chance.ui.ui.theme.fontSize14
import com.the_chance.ui.ui.theme.secondary
import com.the_chance.ui.ui.theme.space4
import com.the_chance.ui.ui.theme.white

@Composable
fun CategoryChip(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
) {
    Card(
        modifier = modifier.wrapContentSize(),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
        border = BorderStroke(width = 0.dp, color = secondary),
        shape = CircleShape
    ) {

        Column(modifier = modifier.align(Alignment.CenterHorizontally)) {
            Text(
                modifier = Modifier.padding(horizontal = space4),
                textAlign = TextAlign.Center,
                fontSize = fontSize14,
                text = text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = white,
                style = style.copy(baselineShift = BaselineShift(0.3f))
            )
        }
    }
}

@Preview
@Composable
fun PreviewCategoryChip() {
    NewsWaveTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CategoryChip(text = "General")
            CategoryChip(text = "Business")
            CategoryChip(text = "Healthy")
            CategoryChip(text = "entrainment")
        }
    }
}