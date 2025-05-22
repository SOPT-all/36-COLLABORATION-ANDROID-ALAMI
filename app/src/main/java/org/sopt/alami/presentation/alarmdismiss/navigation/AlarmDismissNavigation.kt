package org.sopt.alami.presentation.alarmdismiss.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.alami.core.navigation.Route
import org.sopt.alami.presentation.alarmdismiss.AlarmDismissRoute

fun NavController.navigateToAlarmDismiss(navOptions: NavOptions? = null) {
    navigate(AlarmDismiss, navOptions)
}

fun NavGraphBuilder.alarmDismissNavGraph(
    padding: PaddingValues
) {
    composable<AlarmDismiss> {
        AlarmDismissRoute(padding, navigateToHome = {})
    }
}

@Serializable
data object AlarmDismiss : Route
