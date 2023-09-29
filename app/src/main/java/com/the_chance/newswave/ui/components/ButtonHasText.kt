package com.the_chance.newswave.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import com.the_chance.newswave.ui.theme.Primary
import com.the_chance.newswave.ui.theme.white


@Composable
fun FilledButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    isButtonEnabled: Boolean = true,
    isLoading: Boolean = false,
    contentColor: Color = white,
    background: Color = Primary,
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        enabled = isButtonEnabled,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = background,
            contentColor = contentColor,
            disabledContentColor = contentColor,
            disabledContainerColor = background.copy(.5F),
            )
    ) {
//        Loading(state = isLoading)
//        AnimatedVisibility(
//            visible = !isLoading,
//            enter = fadeIn(animationSpec = tween(durationMillis = 500)),
//            exit = fadeOut(animationSpec = tween(durationMillis = 500))
//        ) {
        Text(
            text = label,
            color = contentColor
        )

//        }
    }
}

@Composable
fun TextReuzable(
    text: String,
    textSize: TextUnit = 24.sp,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = White,
    modifier: Modifier = Modifier,
    ){
    Text(
        text = text,
        color = color,
        style = style,
        fontSize = textSize,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}


@Preview
@Composable
private fun HoneyMartButtonPreview() {
    NewsWaveTheme {
        FilledButton(
            label = "Rehab",
            onClick = {},
        )
    }
}