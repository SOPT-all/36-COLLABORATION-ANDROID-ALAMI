package org.sopt.alami.presentation.main

import android.inputmethodservice.Keyboard
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableSet
import org.sopt.alami.core.designsystem.theme.AlamiTheme
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.morning.MorningRoute

@Composable
fun MainBottomBar(
    isVisible: Boolean,
    tabs: ImmutableList<MainTabType>,
    currentTab: MainTabType?,
    onTabSelected: (MainTabType) -> Unit,
    modifier: Modifier = Modifier
) {

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn() + slideIn { IntOffset(0, 0) },
        exit = fadeOut() + slideOut { IntOffset(0, 0) },
    ) {
        Surface(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)

        ) {

            Row(
                modifier = modifier
                    .navigationBarsPadding(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly


            ) {
                tabs.forEach { tab->
                    MainBottomBarItem(
                        isSelected = tab == currentTab,
                        tab = tab,
                        onClick = {onTabSelected(tab)},


                    )

                }

            }

        }
    }


    
}


@Composable
private fun RowScope.MainBottomBarItem(
    isSelected: Boolean,
    tab: MainTabType,
    onClick: () -> Unit,
) {

    val iconRes = if (isSelected) tab.selectedIcon else tab.unselectedIcon

    val textColor = if (isSelected) AlarmiTheme.colors.white else AlarmiTheme.colors.grey400

    Column(
        modifier = Modifier
            .weight(1f)
            .selectable(
                selected = isSelected,
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp, Alignment.CenterVertically)

    ) {
        Icon(
            imageVector = ImageVector.vectorResource(iconRes),
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 1.dp, horizontal = 4.dp)
                .size(28.dp)
        )

        Text(
            text = stringResource(tab.descriptionResId),
            style = AlarmiTheme.typography.caption03r10,
            color = textColor,



        )
    }

}


@Preview
@Composable
private fun MainBottomBarPreview() {

    AlamiTheme {
        var currentTab by remember { mutableStateOf(MainTabType.ALARM) }
        MainBottomBar(
            isVisible = true,
            tabs = MainTabType.entries.toImmutableList(),
            currentTab= currentTab,
            onTabSelected = {currentTab = it}
        )
    }
}

