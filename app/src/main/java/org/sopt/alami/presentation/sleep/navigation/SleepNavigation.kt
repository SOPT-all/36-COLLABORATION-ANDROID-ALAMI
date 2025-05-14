package org.sopt.alami.presentation.sleep.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.sleep.SleepRoute

fun NavController.navigateToSleep(navOptions: NavOptions? = null) {
    navigate(Sleep, navOptions)
}

fun NavGraphBuilder.sleepNavGraph(
    padding: PaddingValues
) {

    composable<Sleep> {
        SleepRoute(padding)
    }

}

@Serializable
data object Sleep : MainTabRoute