package com.the_chance.newswave.ui.components.modifier

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color


fun Modifier.fullOverlay(): Modifier {
    return then(drawWithContent {
        drawContent()
        drawRect(
            color = Color.Black.copy(0.44F),
            size = size,
        )
    })
}