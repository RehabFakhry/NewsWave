package com.the_chance.ui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.the_chance.ui.R
import com.the_chance.ui.ui.theme.NewsWaveTheme
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space56

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ConnectionErrorPlaceholder(state: Boolean) {
    NewsWaveTheme {
        AnimatedVisibility(
            visible = state,
            enter = fadeIn(
                animationSpec = tween(durationMillis = 500)) + slideInVertically() + scaleIn(),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 500)) + slideOutVertically() + scaleOut()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.no_connection_placeholder),
                    contentDescription = stringResource(R.string.network_error),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier,
                )
                Text(
                    text = stringResource(id = R.string.there_is_no_connection),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = space56)
                )
                Text(
                    text = stringResource(id = R.string.please_check_your_network_and_try_later),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = space16),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConnectionErrorScaffold() {
    ConnectionErrorPlaceholder(true)
}