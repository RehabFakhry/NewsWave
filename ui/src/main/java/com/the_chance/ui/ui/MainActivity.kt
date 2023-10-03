package com.the_chance.ui.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.the_chance.ui.ui.theme.NewsWaveTheme
import com.the_chance.ui.ui.navigation.BottomBarUi
import com.the_chance.ui.ui.navigation.LocalNavigationProvider
import com.the_chance.ui.ui.navigation.MainNavGraph
import com.the_chance.ui.ui.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            CompositionLocalProvider(LocalNavigationProvider provides rememberNavController()) {
                NewsWaveTheme {
                    val bottomNavState = checkBottomBarState()
                    Scaffold(
                        bottomBar = {
                            BottomBarUi(bottomNavState)
                        },
                        contentWindowInsets = WindowInsets(0, 0, 0, 0)
                    ) { paddingValues ->
                        Box(
                            modifier = Modifier
                                .background(MaterialTheme.colorScheme.background)
                                .fillMaxSize()
                                .padding(paddingValues)
                        )
                        { MainNavGraph() }
                    }
                }
            }
        }
    }

    @Composable
    private fun checkBottomBarState(): MutableState<Boolean> {
        val navController = LocalNavigationProvider.current
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val bottomBarState = rememberSaveable() { (mutableStateOf(true)) }

        val bottomBarScreens = listOf(
            Screen.HomeScreen.route,
            Screen.DiscoverScreen.route,
            Screen.SavedNewsScreen.route,
            Screen.ProfileScreen.route,
        )
        when (navBackStackEntry?.destination?.route) {
            in bottomBarScreens -> {
                // Show BottomBar
                bottomBarState.value = true
            }

            else -> {
                // Hide BottomBar
                bottomBarState.value = false
            }
        }
        return bottomBarState
    }
}