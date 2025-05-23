package org.sopt.alami.presentation.setting.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.setting.SettingRoute

fun NavController.navigateToSetting(navOptions: NavOptions? = null) {
    navigate(Setting, navOptions)
}

fun NavGraphBuilder.settingNavGraph(
    padding: PaddingValues,
    navController: NavController,
) {
    composable<Setting> {
        SettingRoute(paddingValues = padding, navController = navController)
    }
}

@Serializable
data object Setting : MainTabRoute
