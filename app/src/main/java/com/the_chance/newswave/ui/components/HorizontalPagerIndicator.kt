package com.the_chance.newswave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.the_chance.newswave.ui.theme.space12
import com.the_chance.newswave.ui.theme.space20
import com.the_chance.newswave.ui.theme.space4
import com.the_chance.newswave.ui.theme.space6
import com.the_chance.newswave.ui.theme.space8

@Composable
fun HorizontalPagerIndicator(
    itemCount: Int,
    selectedPage: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until itemCount) {
            PagerIndicatorItem(selected = i == selectedPage)
            Spacer(modifier = Modifier.width(space8))
        }
    }
}

@Composable
fun PagerIndicatorItem(selected: Boolean) {
    val color =
        if (selected) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.outlineVariant
    val width = if (selected) space20 else space12
    val height = space6
    val cornerRadius = space4

    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .background(color, shape = RoundedCornerShape(cornerRadius))
    )
}