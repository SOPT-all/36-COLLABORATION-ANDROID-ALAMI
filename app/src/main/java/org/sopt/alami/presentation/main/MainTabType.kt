package org.sopt.alami.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.alami.R
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.alarm.navigation.Alarm
import org.sopt.alami.presentation.morning.navigation.Morning
import org.sopt.alami.presentation.report.navigation.Report
import org.sopt.alami.presentation.setting.navigation.Setting
import org.sopt.alami.presentation.sleep.navigation.Sleep

enum class MainTabType(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    @StringRes val label: Int,
    val route: MainTabRoute
) {

    ALARM(
        selectedIcon = R.drawable.ic_clockon_28,
        unselectedIcon = R.drawable.ic_clockoff_28,
        label = R.string.bottom_navigation_item_alarm,
        route = Alarm
    ),

    SLEEP(
        selectedIcon = R.drawable.ic_sleep_28,
        unselectedIcon = R.drawable.ic_sleep_28,
        label = R.string.bottom_navigation_item_sleep,
        route = Sleep
    ),

    MORNING(
        selectedIcon = R.drawable.ic_morningon_28,
        unselectedIcon = R.drawable.ic_morningoff_28,
        label = R.string.bottom_navigation_item_morning,
        route = Morning
    ),

    REPORT(
        selectedIcon = R.drawable.ic_report_28,
        unselectedIcon = R.drawable.ic_report_28,
        label = R.string.bottom_navigation_item_report,
        route = Report
    ),

    SETTING(
        selectedIcon = R.drawable.ic_setting_28,
        unselectedIcon = R.drawable.ic_setting_28,
        label = R.string.bottom_navigation_item_setting,
        route = Setting
    );

    companion object {

        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTabType? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
