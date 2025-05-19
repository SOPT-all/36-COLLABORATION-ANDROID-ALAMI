package org.sopt.alami.presentation.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.component.AlamiButton
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.setting.component.AddMission
import org.sopt.alami.presentation.setting.component.AlarmPicker
import org.sopt.alami.presentation.setting.component.DateSelect
import org.sopt.alami.presentation.setting.component.ScreenDivider
import org.sopt.alami.presentation.setting.component.SettingBox
import org.sopt.alami.presentation.setting.component.SoundProgress


@Composable
fun SettingRoute(
    paddingValues: PaddingValues,
) {
    SettingScreen(paddingValues)
}

@Composable
fun SettingScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
) {

    AlamiButton(text = "저장", onClick = {})

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = AlarmiTheme.colors.grey800)
    ) {
        item {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                    contentDescription = null
                )
                Text(
                    text = "1분 이내에 울려요",
                    style = AlarmiTheme.typography.title05b13,
                    color = AlarmiTheme.colors.grey100
                )
                Text(
                    text = "미리보기",
                    style = AlarmiTheme.typography.caption01r13,
                    color = AlarmiTheme.colors.grey100
                )
            }
        }
        item {
            Spacer(modifier = Modifier.height(40.dp))
            AlarmPicker()
        }
        item {
            Spacer(modifier = Modifier.height(10.dp))
            ScreenDivider()
        }
        item {
            DateSelect()
        }
        item {
            ScreenDivider()
        }
        item {
            AddMission()
        }
        item {
            ScreenDivider()
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            SoundProgress(currentPosition = 1f, onSeek = {})
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            SettingBox(text = "사운드", subtext = "오르카니")
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            SettingBox(text = "사운드 파워웝", subtext = "1개 사용")
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
            ScreenDivider()
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            SettingBox(text = "알람 미루기", subtext = "5분,3회")
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            SettingBox(text = "메모", subtext = "메모 없음")
        }
        item {
            Spacer(modifier = Modifier.height(24.dp))
            SettingBox(text = "다시 잠들기 방지", subtext = "사용 안함")
        }

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreviewScreen() {
    AlamiTheme {
        SettingScreen(paddingValues = PaddingValues())
    }
}
