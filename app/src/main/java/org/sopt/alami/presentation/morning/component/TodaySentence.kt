package org.sopt.alami.presentation.morning.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun TodaySentence(
    imageUrl: Int,
    modifier: Modifier = Modifier
) {
    MorningSurface(
        modifier = modifier
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "오늘의 문장",
                    style = AlarmiTheme.typography.body01b15,
                    color = AlarmiTheme.colors.white
                )

                Text(
                    modifier = Modifier
                        .border(
                            1.dp,
                            AlarmiTheme.colors.white,
                            RoundedCornerShape(4.dp)
                        )
                        .clip(RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 7.dp),
                    text = "공유하기",
                    style = AlarmiTheme.typography.body02b12,
                    color = AlarmiTheme.colors.white
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(
                    id = when (imageUrl) {
                        1 -> R.drawable.img_today_quote1_and
                        2 -> R.drawable.img_today_quote2_and
                        3 -> R.drawable.img_today_quote3_and
                        4 -> R.drawable.img_today_quote4_and
                        5 -> R.drawable.img_today_quote5_and
                        6 -> R.drawable.img_today_quote6_and
                        else -> R.drawable.img_today_quote1_and
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .aspectRatio(290 / 124f)
            )
        }
    }
}
