package com.the_chance.newswave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.theme.icon32

@Composable
fun IconButton(
    size: Dp = icon32,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    content: @Composable () -> Unit,
) {
    IconButton(
        modifier = modifier
            .size(size)
            .background(backgroundColor, shape = shape)
            .clip(shape),
        onClick = onClick
    ) {
        content()
    }
}

@Preview
@Composable
fun IconButtonPreview() {
    IconButton(
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "",
                tint = Color.White
            )
        },
        onClick = {}
    )
}