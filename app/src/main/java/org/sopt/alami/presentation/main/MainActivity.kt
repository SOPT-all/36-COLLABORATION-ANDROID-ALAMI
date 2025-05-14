package org.sopt.alami.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import org.sopt.alami.core.designsystem.theme.AlamiTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navigator: MainNavigator = rememberMainNavigator()

            AlamiTheme {
                MainScreen(
                    navigator = navigator
                )
            }
        }
    }
}

