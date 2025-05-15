package org.sopt.alami.presentation.alarm

import android.R.attr.padding
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun AlarmRoute(
    paddingValues: PaddingValues
) {
    AlarmScreen(paddingValues)
}

@Composable
fun AlarmScreen(
    paddingValues: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AlarmiTheme.colors.black)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Alarm",
            textAlign = TextAlign.Center
        )
    }
}
