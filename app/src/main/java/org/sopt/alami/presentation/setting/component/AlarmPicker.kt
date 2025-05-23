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
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.flow.MutableStateFlow
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.setting.model.AlarmSettingViewModel

@Composable
fun AlarmPicker(viewModel: AlarmSettingViewModel) {
    val ampm = listOf("오전", "오후")
    val hours = (1..12).toList()
    val minutes = (0..59).toList()

    val selectedAmpmIndex = remember { MutableStateFlow(0) }
    val selectedHourIndex = remember { MutableStateFlow(0) }
    val selectedMinuteIndex = remember { MutableStateFlow(0) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(AlarmiTheme.colors.grey800),
            horizontalArrangement = Arrangement.Center
        ) {
            PickerColumn(items = ampm, onValueChange = { selectedAmpmIndex.value = it })
            PickerColumn(
                items = hours.map { it.toString() },
                onValueChange = { selectedHourIndex.value = it })
            Spacer(modifier = Modifier.width(40.dp))
            PickerColumn(
                items = minutes.map { it.toString().padStart(2, '0') },
                onValueChange = { selectedMinuteIndex.value = it })
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
    LaunchedEffect(selectedAmpmIndex, selectedHourIndex, selectedMinuteIndex) {
        snapshotFlow {
            Triple(
                selectedAmpmIndex.value,
                selectedHourIndex.value,
                selectedMinuteIndex.value
            )
        }
            .collect { (ampm, hour, minute) ->
                viewModel.setAlarmTime(hour + 1, minute, ampm == 0)
            }
    }
}

@Composable
fun PickerColumn(
    items: List<String>,
    onValueChange: (Int) -> Unit,
) {
    val listState = rememberLazyListState()
    val itemHeight = 48.dp
    val itemHeightPx = with(LocalDensity.current) { itemHeight.toPx() }

    // 컨테이너의 중앙점 계산 (240dp 높이의 절반)
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

            // 더 정확한 중앙 감지 로직
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
                    .zIndex(if (isSelected) 5f else 2f) // 선택된 텍스트를 가장 위로
                    .height(itemHeight)
                    .padding(vertical = 4.dp)
            )
        }
    }

    // 스크롤 위치에 따라 자동으로 중앙에 스냅하는 효과
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemScrollOffset }
            .collect { offset ->
                val firstVisibleIndex = listState.firstVisibleItemIndex
                val itemOffset = offset.toFloat()

                // 가장 가까운 아이템으로 스냅
                if (itemOffset > itemHeightPx / 2f && firstVisibleIndex < items.size + 1) {
                    listState.animateScrollToItem(firstVisibleIndex + 1)
                } else if (itemOffset < -itemHeightPx / 2f && firstVisibleIndex > 2) {
                    listState.animateScrollToItem(firstVisibleIndex - 1)
                }
            }
    }
}