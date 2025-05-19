package org.sopt.alami.presentation.alarm.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.alami.R
import org.sopt.alami.core.designsystem.theme.AlarmiTheme

@Composable
fun AddAlarmButton(onClicked: () -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        if (isExpanded) {
            Box(
                modifier = Modifier
                    .background(color = AlarmiTheme.colors.black.copy(alpha = 0.8f))
                    .clickable { isExpanded = false }

            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 76.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End

        ) {
            if (isExpanded) {
                FabItem(
                    title = "습관 알람",
                    icon = ImageVector.vectorResource(R.drawable.ic_floating_calendar_28),
                    onClicked = {}
                )

                Spacer(modifier = Modifier.height(17.dp))

                FabItem(
                    title = "퀵 알람",
                    icon = ImageVector.vectorResource(R.drawable.ic_floating_quick_28),
                    onClicked = {}
                )

                Spacer(modifier = Modifier.height(17.dp))

                FabItem(
                    title = "알람",
                    icon = ImageVector.vectorResource(R.drawable.ic_floating_clock_28),
                    onClicked = {}
                )

                Spacer(modifier = Modifier.height(17.dp))
            }
            FloatingActionButton(
                onClick = { isExpanded = !isExpanded },
                shape = CircleShape,
                containerColor = AlarmiTheme.colors.redPrimary

            ) {
                Icon(
                    imageVector = if (isExpanded) {
                        ImageVector.vectorResource(
                            R.drawable.ic_floating_close_28
                        )
                    } else {
                        ImageVector.vectorResource(
                            R.drawable.ic_floating_plus_28

                        )
                    },
                    contentDescription = null,
                    tint = AlarmiTheme.colors.grey100

                )
            }
        }
    }
}

@Composable
fun FabItem(
    title: String,
    icon: ImageVector,
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = AlarmiTheme.typography.body01b15,
            color = AlarmiTheme.colors.grey100
        )

        Spacer(modifier = Modifier.width(12.dp))

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = AlarmiTheme.colors.grey100,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AlarmiTheme.colors.grey900
            )
        }
    }
}
