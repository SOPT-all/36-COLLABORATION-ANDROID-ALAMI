package org.sopt.alami.presentation.alarm.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.alarm.AlarmRoute

fun NavController.navigateToAlarm(navOptions: NavOptions ? = null) {
    navigate(Alarm, navOptions)
}

fun NavGraphBuilder.alarmNavGraph(
    padding: PaddingValues
) {
    composable<Alarm> { AlarmRoute(padding) }
}

@Serializable data object Alarm : MainTabRoute
