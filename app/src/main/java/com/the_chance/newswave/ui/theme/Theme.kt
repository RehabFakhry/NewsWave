package com.the_chance.newswave.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.material.color.utilities.MaterialDynamicColors.primary

//private val localDimens = compositionLocalOf { Dimens() }

private val DarkColorScheme = darkColorScheme(
    primaryContainer = darkBackground400,
    primary = Primary,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = white,
    onBackground = darkText87,
    onSecondaryContainer = black60,
    onTertiary = darkBackground300,
    onTertiaryContainer = black37,
    surface = darkBackground200,
    outlineVariant = white,
    errorContainer = darkBackground400,
    onErrorContainer = Primary,



    )

private val LightColorScheme = lightColorScheme(
    primaryContainer = white,
    primary = Primary,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = white,
    onBackground = blackOn87,
    onSecondaryContainer = blackOn60,
    onTertiary = white,
    onTertiaryContainer = black16,
    surface = background,
    outlineVariant = black8,
    errorContainer = Primary,
    onErrorContainer = black37,






    )

//val MaterialTheme.dimens: Dimens
//    @Composable
//    @ReadOnlyComposable
//    get() = localDimens.current
//

@Composable
fun NewsWaveTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val systemUiController = rememberSystemUiController()
    val darkIcons = !darkTheme

    DisposableEffect(systemUiController, darkIcons) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = darkIcons,
            isNavigationBarContrastEnforced = false
        )

        onDispose {}
        }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}