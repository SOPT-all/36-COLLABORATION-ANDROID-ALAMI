package org.sopt.alami.presentation.setting.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
fun DateSelect(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(136.dp)
            .background(color = AlarmiTheme.colors.grey800)
            .padding(start = 22.dp, end = 22.dp),


        ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(

        ) {
            Text(
                text = "월, 화, 수, 목, 금, 토, 일",
                style = AlarmiTheme.typography.body01b15,
                color = AlarmiTheme.colors.white,
                modifier = Modifier
                    .weight(1F)
            )

            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_checkbox),
                contentDescription = null
            )

            Text(
                text = "매일",
                style = AlarmiTheme.typography.body06r14,
                color = AlarmiTheme.colors.white,
                modifier = Modifier
                    .padding(start = 12.dp)
            )


        }
        Spacer(modifier = Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_sunday),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_monday),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_tuesday),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_wendseday),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_thursday),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_friday),
                contentDescription = null
            )
            Image(
                imageVector = ImageVector.vectorResource(id = org.sopt.alami.R.drawable.ic_date_saturday),
                contentDescription = null
            )


        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreviewdate() {
    AlamiTheme {
        DateSelect()
    }
}
