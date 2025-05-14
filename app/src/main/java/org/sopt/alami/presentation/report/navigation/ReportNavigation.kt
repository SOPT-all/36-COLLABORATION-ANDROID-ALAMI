package org.sopt.alami.presentation.report.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.alami.core.navigation.MainTabRoute
import org.sopt.alami.presentation.report.ReportRoute

fun NavController.navigateToReport(navOptions: NavOptions? = null) {
    navigate(Report, navOptions)
}

fun NavGraphBuilder.reportNavGraph(
    padding: PaddingValues
) {

    composable<Report> {
        ReportRoute(padding)
    }

}

@Serializable data object Report : MainTabRoute