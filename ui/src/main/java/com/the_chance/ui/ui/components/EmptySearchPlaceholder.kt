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
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
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
fun EmptySearchPlaceholder(state: Boolean){
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
                    painter = painterResource(id = R.drawable.no_result_placeholder),
                    contentDescription = stringResource(R.string.no_search_result),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(R.string.there_is_no_result),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = space56),
                    )
                Text(
                    text = stringResource(R.string.please_try_again_with_another_words),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = space16),
                    )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewEmptyProductsScaffold(){
    EmptySearchPlaceholder(true)
}