package org.sopt.alami.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
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
    Box(
        modifier = modifier
            .fillMaxSize()

    ) {

        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination

        ) {

            alarmNavGraph(padding)
            sleepNavGraph(padding)
            morningNavGraph(padding)
            reportNavGraph(padding)
            settingNavGraph(padding)


        }

    }

}