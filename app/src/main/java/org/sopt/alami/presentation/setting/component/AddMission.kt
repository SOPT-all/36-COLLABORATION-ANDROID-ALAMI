package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun AddMission(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .background(color = AlarmiTheme.colors.grey800)
            .padding(top = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .height(68.dp)
                .padding(start = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "미션",
                style = AlarmiTheme.typography.body01b15,
                color = AlarmiTheme.colors.white
            )
            Text(
                text = "0/5",
                style = AlarmiTheme.typography.body06r14,
                color = AlarmiTheme.colors.grey300
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .padding(start = 28.dp),
            contentPadding = PaddingValues(end = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.ic_mission_on),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 15.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_setting_mission),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .height(68.dp)
                        .width(68.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_setting_mission),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .height(68.dp)
                        .width(68.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_setting_mission),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .height(68.dp)
                        .width(68.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.img_setting_mission),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .height(68.dp)
                        .width(68.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewMission() {
    AlamiTheme {
        AddMission()
    }
}
