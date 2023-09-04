package com.the_chance.newswave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.the_chance.newswave.ui.features.home.HomeScreen
import com.the_chance.newswave.ui.theme.NewsWaveTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            NewsWaveTheme {
                // A surface container using the 'background' color from the theme

//                HomeScreen()
            }
        }
    }
}
