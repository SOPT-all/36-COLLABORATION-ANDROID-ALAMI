package org.sopt.alami.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.alami.presentation.alarm.navigation.alarmNavGraph
import org.sopt.alami.presentation.morning.navigation.morningNavGraph
import org.sopt.alami.presentation.report.navigation.reportNavGraph
import org.sopt.alami.presentation.setting.navigation.settingNavGraph
import org.sopt.alami.presentation.sleep.navigation.sleepNavGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
        modifier = modifier

    ) {
        alarmNavGraph(
            padding = padding,
            navigateToAlarmDismiss = navigator::navigateToAlarmDismiss
        )
        sleepNavGraph(padding)
        morningNavGraph(padding)
        reportNavGraph(padding)
        settingNavGraph(padding)
    }
}
