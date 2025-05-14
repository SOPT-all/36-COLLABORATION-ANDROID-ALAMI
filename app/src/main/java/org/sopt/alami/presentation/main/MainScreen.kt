package org.sopt.alami.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.toPersistentList
import org.sopt.alami.core.designsystem.theme.AlarmiTheme


@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator()
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),

        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding,
                modifier = Modifier
            )

        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier
                    .background(color = AlarmiTheme.colors.grey800)
                    .navigationBarsPadding(),
                isVisible = navigator.showBottomNavigator(),
                tabs = MainTabType.entries.toPersistentList(),
                currentTab = navigator.currentTab,
                onTabSelected = { navigator.navigate(it) }

            )
        }

    )



}

