package com.the_chance.newswave.ui.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.FilledButton
import com.the_chance.newswave.ui.components.Text
import com.the_chance.newswave.ui.features.home.navigateToHomeScreen
import com.the_chance.newswave.ui.navigation.LocalNavigationProvider
import com.the_chance.newswave.ui.theme.fontSize20
import com.the_chance.newswave.ui.theme.fontSize30
import com.the_chance.newswave.ui.theme.space16
import com.the_chance.newswave.ui.theme.space8

@Composable
fun OnboardingScreen() {
    val navController = LocalNavigationProvider.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_onboarding),
            contentDescription = stringResource(R.string.onboarding_image),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize(),
        )

       Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = space16)
        ) {
            Text(
                text = stringResource(R.string.stay_informed_with_news_waves),
                textSize = fontSize30,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = space16 ,
                        vertical = space8)
            )
           Text(
               text = stringResource(R.string.get_ready_to_dive_into_the_headlines),
               textSize = fontSize20,
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(horizontal = space16)
           )
           FilledButton(
                onClick = {navController.navigateToHomeScreen()},
                label = stringResource(R.string.get_started),
                modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp),
            )
        }
    }
}

@Composable
@Preview(showBackground = true,)
fun PreviewOnboarding(){
    OnboardingScreen()
}