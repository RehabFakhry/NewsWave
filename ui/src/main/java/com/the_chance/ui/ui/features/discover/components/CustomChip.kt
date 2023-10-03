package com.the_chance.ui.ui.features.discover.components

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.the_chance.ui.ui.theme.NewsWaveTheme
import com.the_chance.ui.ui.theme.black60
import com.the_chance.ui.ui.theme.fontSize14
import com.the_chance.ui.ui.theme.secondary
import com.the_chance.ui.ui.theme.space4
import com.the_chance.ui.ui.theme.white

@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
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
        colors = if (isSelected) CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
        else CardDefaults.cardColors(MaterialTheme.colorScheme.onSecondary),
        border = if (isSelected) BorderStroke(width = 0.dp, color = secondary,
        )
        else BorderStroke(width = 1.dp, color = Transparent),
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
                color = if (isSelected) white else black60,
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
            CustomChip(isSelected = true, text = "General", onClick = { })
            CustomChip(isSelected = false, text = "Business", onClick = { })
            CustomChip(isSelected = false, text = "Healthy", onClick = { })
            CustomChip(isSelected = false, text = "entrainment", onClick = { })
        }
    }
}