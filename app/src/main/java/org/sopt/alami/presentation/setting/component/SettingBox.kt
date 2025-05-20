package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun SettingBox(
    text: String,
    subtext: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(24.dp)
            .background(color = AlarmiTheme.colors.grey800)
            .padding(start = 22.dp, end = 22.dp, top = 3.dp, bottom = 3.dp),
        horizontalArrangement = Arrangement.Center

    ) {
        Text(
            text = text,
            style = AlarmiTheme.typography.body01b15,
            color = AlarmiTheme.colors.white,
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = subtext,
            style = AlarmiTheme.typography.body01b15,
            color = AlarmiTheme.colors.white
        )
        Image(
            imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_button_detail),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 4.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewSettingBox() {
    AlamiTheme {
        SettingBox(text = "사운드", subtext = "오르카니")
    }
}