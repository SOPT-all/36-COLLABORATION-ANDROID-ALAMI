package org.sopt.alami.presentation.sleep

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
fun SleepRoute(
    padding: PaddingValues
) {

    SleepScreen(padding)

}

@Composable
fun SleepScreen(
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
            text = "Sleep",
            textAlign = TextAlign.Center
        )
    }

}