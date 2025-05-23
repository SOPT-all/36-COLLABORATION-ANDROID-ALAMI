package org.sopt.alami.presentation.setting


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.alarm.navigation.navigateToAlarm
import org.sopt.alami.presentation.setting.component.AddMission
import org.sopt.alami.presentation.setting.component.AlarmPicker
import org.sopt.alami.presentation.setting.component.DateSelect
import org.sopt.alami.presentation.setting.component.FloatingAlamiButton
import org.sopt.alami.presentation.setting.component.ScreenDivider
import org.sopt.alami.presentation.setting.component.SettingBox
import org.sopt.alami.presentation.setting.component.SoundProgress
import org.sopt.alami.presentation.setting.model.AlarmSettingViewModel
import org.sopt.alami.presentation.setting.model.SettingItem


@Composable
fun SettingRoute(
    paddingValues: PaddingValues,
    navController: NavController,
) {
    val viewModel: AlarmSettingViewModel = hiltViewModel()
    val alarmResult by viewModel.alarmResult.collectAsState()

    LaunchedEffect(alarmResult) {
        if (alarmResult is AlarmSettingViewModel.ResultState.Success) {
            navController.popBackStack()
            navController.navigateToAlarm()
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {

        SettingScreen(
            paddingValues = PaddingValues(),
            viewModel = viewModel
        )

        if (alarmResult != AlarmSettingViewModel.ResultState.Idle) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 96.dp)
            ) {
                when (alarmResult) {
                    is AlarmSettingViewModel.ResultState.Loading -> {
                        Text("알람 저장 중...", color = AlarmiTheme.colors.grey100)
                    }

                    is AlarmSettingViewModel.ResultState.Success -> {
                        Text("저장 성공!", color = AlarmiTheme.colors.grey100)
                    }

                    is AlarmSettingViewModel.ResultState.Error -> {
                        val msg = (alarmResult as AlarmSettingViewModel.ResultState.Error).message
                        Text("오류 발생: $msg", color = AlarmiTheme.colors.grey100)
                    }

                    else -> {}
                }
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp, start = 16.dp, end = 16.dp)
        ) {
            FloatingAlamiButton(
                text = "저장",
                onClick = { viewModel.addAlarm(userId = 1L) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun SettingScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    viewModel: AlarmSettingViewModel = hiltViewModel(),
) {
    val settingItems = listOf(
        SettingItem("사운드", "오르카니"),
        SettingItem("사운드 파워웝", "1개 사용"),
        SettingItem("알람 미루기", "5분,3회"),
        SettingItem("메모", "메모 없음"),
        SettingItem("다시 잠들기 방지", "사용 안함")
    )

    val alarmResult by viewModel.alarmResult.collectAsState()

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
            AlarmPicker(viewModel = viewModel)
        }

        item {
            Spacer(modifier = Modifier.height(40.dp))
            ScreenDivider()
        }
        item { DateSelect() }
        item { ScreenDivider() }
        item { AddMission() }
        item { ScreenDivider() }

        item {
            SoundProgress(currentPosition = 1f, onSeek = {})
        }
        items(settingItems.size) { index ->
            val item = settingItems[index]

            Spacer(modifier = Modifier.height(24.dp))

            SettingBox(
                text = item.title,
                subtext = item.subtitle,
            )
            if (index == 1) {
                Spacer(modifier = Modifier.height(20.dp))
                ScreenDivider()
            }
        }

    }

}
