package org.sopt.alami.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.toPersistentList
import org.sopt.alami.core.designsystem.theme.AlarmiTheme
import org.sopt.alami.presentation.main.component.MainBottomBar

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        bottomBar = {
            MainBottomBar(
                modifier = Modifier.background(AlarmiTheme.colors.grey800),
                isVisible = navigator.showBottomNavigator(),
                tabs = MainTabType.entries.toPersistentList(),
                currentTab = navigator.currentTab,
                onTabSelected = navigator::navigate
            )
        }
    ) { padding ->
        MainNavHost(
            navigator = navigator,
            padding = padding,
            modifier = Modifier
        )
    }
}
