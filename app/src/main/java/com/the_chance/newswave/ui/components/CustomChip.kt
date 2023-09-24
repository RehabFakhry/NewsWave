package com.the_chance.newswave.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import com.the_chance.newswave.ui.theme.black37
import com.the_chance.newswave.ui.theme.fontSize14
import com.the_chance.newswave.ui.theme.space2
import com.the_chance.newswave.ui.theme.space4
import com.the_chance.newswave.ui.theme.white

@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    state: Boolean,
    text: String,
    width: Dp = 70.dp,
    height: Dp = 32.dp,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Card(
        modifier = modifier
            .width(width)
            .height(height)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                onClick()
            },
        colors = if (state) CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
        else CardDefaults.cardColors(Transparent),
        border = if (state) BorderStroke(width = 0.dp, color = Transparent)
        else BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onTertiaryContainer),
        shape = CircleShape
    ) {

        Column(modifier = modifier.align(Alignment.CenterHorizontally)) {
            Text(
                modifier = Modifier.padding(start = space4),
                textAlign = TextAlign.Center,
                fontSize = fontSize14,
                text = text,
                color = if (state) white else black37,
                style = style.copy(baselineShift = BaselineShift(0.3f))
            )
        }
    }
}

@Preview
@Composable
fun PreviewCustomChip() {
    NewsWaveTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomChip(state = true, text = "General", onClick = { })
            CustomChip(state = false, text = "Business", onClick = { })
            CustomChip(state = false, text = "Healthy", onClick = { })
        }
    }
}