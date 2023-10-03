package com.the_chance.ui.ui.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.the_chance.ui.ui.navigation.LocalNavigationProvider
import com.the_chance.ui.ui.theme.fontSize20
import com.the_chance.ui.ui.theme.fontSize30
import com.the_chance.ui.ui.theme.space16
import com.the_chance.ui.ui.theme.space8
import com.the_chance.ui.R
import com.the_chance.ui.ui.components.FilledButton
import com.the_chance.ui.ui.components.TextReuzable
import com.the_chance.ui.ui.features.home.navigateToHomeScreen

@Composable
fun OnboardingScreen() {
    val navController = LocalNavigationProvider.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_onboarding),
            contentDescription = stringResource(R.string.onboarding_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

       Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = space16)
        ) {
            TextReuzable(
                text = stringResource(R.string.stay_informed_with_news_waves),
                textSize = fontSize30,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = space16 ,
                        vertical = space8
                    )
            )
           TextReuzable(
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