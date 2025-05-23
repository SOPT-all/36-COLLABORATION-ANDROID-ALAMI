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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun AlarmPicker(
    initialHour: Int,
    initialMinute: Int,
    initialIsAm: Boolean,
    onTimeChange: (Int, Int, Boolean) -> Unit,
) {
    var hour by rememberSaveable { mutableStateOf(initialHour) }
    var minute by rememberSaveable { mutableStateOf(initialMinute) }
    var isAm by rememberSaveable { mutableStateOf(initialIsAm) }

    val ampm = listOf("오전", "오후")
    val hours = (1..12).toList()
    val minutes = (0..59).toList()

    LaunchedEffect(hour, minute, isAm) {
        onTimeChange(hour, minute, isAm)
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(240.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            PickerColumn(ampm, if (isAm) 0 else 1) { isAm = it == 0 }
            PickerColumn(hours.map { it.toString() }, hour - 1) { hour = it + 1 }
            Spacer(Modifier.width(40.dp))
            PickerColumn(minutes.map { it.toString().padStart(2, '0') }, minute) { minute = it }
        }

        Box(
            modifier = Modifier
                .zIndex(3f)
                .align(Alignment.Center)
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(AlarmiTheme.colors.grey600.copy(alpha = 0.3f))
        )
    }
}


@Composable
fun PickerColumn(
    items: List<String>,
    selectedIndex: Int,
    onValueChange: (Int) -> Unit,
) {
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = selectedIndex + 2)

    val itemHeight = 48.dp
    val itemHeightPx = with(LocalDensity.current) { itemHeight.toPx() }
    val containerCenterY = with(LocalDensity.current) { 120.dp.toPx() }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .width(73.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        itemsIndexed(List(2) { "" } + items + List(2) { "" }) { index, item ->
            val layoutInfo = listState.layoutInfo.visibleItemsInfo.find { it.index == index }
            val itemCenter = layoutInfo?.let { it.offset + it.size / 2f }

            val isSelected = item.isNotBlank() &&
                    itemCenter != null &&
                    kotlin.math.abs(itemCenter - containerCenterY) < itemHeightPx / 2f

            if (isSelected) {
                onValueChange(index - 2)
            }

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
                    .zIndex(if (isSelected) 5f else 2f)
                    .height(itemHeight)
                    .padding(vertical = 4.dp)
            )
        }
    }
}

