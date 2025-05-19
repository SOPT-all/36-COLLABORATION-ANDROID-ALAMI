package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun AlarmPicker() {
    val hours = (1..12).toList()
    val minutes = (0..59).map { it.toString().padStart(2, '0') }

    Box {

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AlarmiTheme.colors.grey600.copy(alpha = 0.8f))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(AlarmiTheme.colors.grey800),
            horizontalArrangement = Arrangement.Center
        ) {

            TimeColumn(items = listOf("오전", "오후"), isScrollable = true)

            TimeColumn(items = hours.map { it.toString() }, isScrollable = true)
            Spacer(modifier = Modifier.width(40.dp))

            TimeColumn(items = minutes, isScrollable = true)
        }
    }
}

@Composable
fun TimeColumn(items: List<String>, isScrollable: Boolean = true) {
    val listState = rememberLazyListState()
    val visibleMiddleIndex by remember {
        derivedStateOf {
            if (isScrollable) {
                listState.firstVisibleItemIndex + 2
            } else {
                0
            }
        }
    }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .width(73.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        userScrollEnabled = isScrollable
    ) {
        itemsIndexed(items) { index, item ->
            val isSelected = index == visibleMiddleIndex
            Text(
                text = item,
                style = if (isSelected)
                    AlarmiTheme.typography.title02b30
                else
                    AlarmiTheme.typography.title03b22,
                color = if (isSelected)
                    AlarmiTheme.colors.white
                else
                    AlarmiTheme.colors.grey400,
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPrevieMission() {
    AlamiTheme {
        AlarmPicker()
    }
}