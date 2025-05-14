package org.sopt.alami.presentation.report

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun ReportRoute(
    padding: PaddingValues
) {

    ReportScreen(padding)

}

@Composable
fun ReportScreen(
    padding: PaddingValues
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmiTheme.colors.black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        Text(
            text = "Report",
            textAlign = TextAlign.Center
        )
    }

}