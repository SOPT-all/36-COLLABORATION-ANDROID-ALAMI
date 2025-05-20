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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun AlarmPicker() {
    val ampm = listOf("오전", "오후")
    val hours = (1..12).map { it.toString() }
    val minutes = (0..59).map { it.toString().padStart(2, '0') }

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
            TimeColumn(items = ampm)
            TimeColumn(items = hours)
            Spacer(modifier = Modifier.width(40.dp))
            TimeColumn(items = minutes)
        }
        Box(
            modifier = Modifier
                .zIndex(1f)
                .align(Alignment.Center)
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(AlarmiTheme.colors.grey600.copy(alpha = 0.8f))
        )


    }
}

@Composable
fun TimeColumn(
    items: List<String>,
    visibleItemsCount: Int = 5,
) {
    val listState = rememberLazyListState()
    val itemHeightDp = 48.dp
    val itemHeightPx = with(LocalDensity.current) { itemHeightDp.toPx() }
    val middleIndex = visibleItemsCount / 2
    val paddingSize = middleIndex
    val paddedItems = List(paddingSize) { "" } + items + List(paddingSize) { "" }

    val centerY by remember {
        derivedStateOf {
            itemHeightPx * middleIndex
        }
    }

    Box(
        modifier = Modifier
            .width(73.dp)
            .fillMaxHeight()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier
                .width(73.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(paddedItems) { index, item ->
                val layoutInfo = listState.layoutInfo.visibleItemsInfo.find { it.index == index }
                val itemCenter = layoutInfo?.let { it.offset + it.size / 2 }
                val isSelected =
                    item.isNotBlank() && itemCenter != null && kotlin.math.abs(itemCenter - centerY) < itemHeightPx / 2

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
                        .zIndex(if (isSelected) 4f else 0f)
                        .height(itemHeightDp)
                        .padding(vertical = 4.dp)
                )
            }
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