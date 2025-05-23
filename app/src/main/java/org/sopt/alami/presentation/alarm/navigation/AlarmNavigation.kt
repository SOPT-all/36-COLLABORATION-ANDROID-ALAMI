package org.sopt.alami.presentation.alarm.navigation

import android.R.attr.padding
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
    padding: PaddingValues,
    navigateToAlarmDismiss:() -> Unit
) {
    composable<Alarm> { AlarmRoute(
        paddingValues = padding,
        navigateToAlarmDismiss = navigateToAlarmDismiss) }
}

@Serializable
data object Alarm : MainTabRoute
