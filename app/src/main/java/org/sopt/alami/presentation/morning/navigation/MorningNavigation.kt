package org.sopt.alami.presentation.morning.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.morning.MorningRoute

fun NavController.navigateToMorning(navOptions: NavOptions? = null) {
    navigate(Morning, navOptions)
}

fun NavGraphBuilder.morningNavGraph(
    padding: PaddingValues
) {

    composable<Morning> {
        MorningRoute(padding)

    }
}

@Serializable
data object Morning : MainTabRoute