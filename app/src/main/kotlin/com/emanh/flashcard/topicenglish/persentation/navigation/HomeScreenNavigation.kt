package com.emanh.flashcard.topicenglish.persentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.emanh.flashcard.topicenglish.persentation.navigation.route.AppNavigationRoute
import com.emanh.flashcard.topicenglish.persentation.ui.home.HomeScreen

fun NavGraphBuilder.homeScreenGraph() {
    composable<AppNavigationRoute.Home> {
        HomeScreen()
    }
}

object HomeScreenNavigation {
    fun getRoute() = AppNavigationRoute.Home
}