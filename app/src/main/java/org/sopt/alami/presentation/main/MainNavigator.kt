package org.sopt.alami.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.alami.presentation.alarm.navigation.Alarm
import org.sopt.alami.presentation.alarm.navigation.navigateToAlarm
import org.sopt.alami.presentation.morning.navigation.navigateToMorning
import org.sopt.alami.presentation.report.navigation.navigateToReport
import org.sopt.alami.presentation.setting.navigation.navigateToSetting
import org.sopt.alami.presentation.sleep.navigation.navigateToSleep

class MainNavigator (

    val navController: NavHostController

) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    val startDestination = Alarm

    val currentTab: MainTabType?
        @Composable get() = MainTabType.find { mainTabItemType ->
            currentDestination?.hasRoute(mainTabItemType::class) == true
        }


    fun navigate(mainTabItemType : MainTabType) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }

        when(mainTabItemType) {
            MainTabType.ALARM -> navController.navigateToAlarm(navOptions)
            MainTabType.SLEEP -> navController.navigateToSleep(navOptions)
            MainTabType.MORNING -> navController.navigateToMorning(navOptions)
            MainTabType.REPORT -> navController.navigateToReport(navOptions)
            MainTabType.SETTING -> navController.navigateToSetting(navOptions)
        }
    }

    fun navigateUp() {
        navController.navigateUp()
    }



    @Composable
    fun showBottomNavigator() = MainTabType.contains {
        currentDestination?.hasRoute(it::class) == true
    }



}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController()

): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
