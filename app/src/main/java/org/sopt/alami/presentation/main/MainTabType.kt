package org.sopt.alami.presentation.main

import android.R.attr.entries
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.security.crypto.MasterKey
import org.sopt.alami.R
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.alarm.navigation.Alarm
import org.sopt.alami.presentation.morning.navigation.Morning
import org.sopt.alami.presentation.report.navigation.Report
import org.sopt.alami.presentation.setting.navigation.Setting
import org.sopt.alami.presentation.sleep.navigation.Sleep
import java.nio.charset.CodingErrorAction.REPORT
import java.nio.file.attribute.AclEntryType.ALARM

enum class MainTabType(
    @DrawableRes val selectedIcon : Int,
    @DrawableRes val unselectedIcon : Int,
    @StringRes val descriptionResId : Int,
    val route: MainTabRoute
) {

    ALARM(
        selectedIcon = R.drawable.ic_clockon_28,
        unselectedIcon = R.drawable.ic_clockoff_28,
        descriptionResId = R.string.bottom_navigation_item_alarm,
        route = Alarm
    ),

    SLEEP(
        selectedIcon = R.drawable.ic_sleep_28,
        unselectedIcon = R.drawable.ic_sleep_28,
        descriptionResId = R.string.bottom_navigation_item_sleep,
        route = Sleep
    ),

    MORNING(
        selectedIcon = R.drawable.ic_morningon_28,
        unselectedIcon = R.drawable.ic_morningoff_28,
        descriptionResId = R.string.bottom_navigation_item_morning,
        route = Morning
    ),

    REPORT(
        selectedIcon = R.drawable.ic_report_28,
        unselectedIcon = R.drawable.ic_report_28,
        descriptionResId = R.string.bottom_navigation_item_report,
        route = Report
    ),

    SETTING(
        selectedIcon = R.drawable.ic_setting_28,
        unselectedIcon = R.drawable.ic_setting_28,
        descriptionResId = R.string.bottom_navigation_item_setting,
        route = Setting
    );


    companion object{

        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean) : MainTabType? {

            return entries.find { predicate(it.route) }

        }

        @Composable
        fun contains(predicate: @Composable (MainTabRoute)-> Boolean) : Boolean {

            return entries.map { it.route }.any { predicate(it) }

        }

    }


}