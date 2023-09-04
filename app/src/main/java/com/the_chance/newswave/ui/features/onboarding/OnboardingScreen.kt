package com.the_chance.newswave.ui.features.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.the_chance.newswave.R
import com.the_chance.newswave.ui.components.FilledButton
import com.the_chance.newswave.ui.components.TextButton
import com.the_chance.newswave.ui.theme.dimens

@Composable
fun OnboardingScreen() {
//    val navController = LocalNavigationProvider.current
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
                .padding(horizontal = MaterialTheme.dimens.space16)
        ) {
            TextButton(
                text = stringResource(R.string.stay_informed_with_news_waves),
                textSize = MaterialTheme.dimens.fontSize30,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MaterialTheme.dimens.space16 ,
                        vertical = MaterialTheme.dimens.space8)
            )
           TextButton(
                text = stringResource(R.string.get_ready_to_dive_into_the_headlines),
                textSize = MaterialTheme.dimens.fontSize20,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.dimens.space16)
            )
           FilledButton(
                onClick = {},
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

