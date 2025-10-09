package com.emanh.flashcard.topicenglish.persentation.composable

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emanh.common.composable.navigation.navigator.AppNavigator
import com.emanh.flashcard.topicenglish.persentation.navigation.homeScreenGraph
import com.emanh.flashcard.topicenglish.persentation.navigation.languageScreenGraph
import com.emanh.flashcard.topicenglish.persentation.navigation.route.AppNavigationRoute
import com.emanh.flashcard.topicenglish.persentation.navigation.testScreenGraph

@Composable
fun FTEAppNavigation(
    modifier: Modifier = Modifier, appNavigator: AppNavigator, navController: NavHostController,
) {
    LaunchedEffect(navController) {
        appNavigator.bind(navController)
    }

    NavHost(modifier = modifier.fillMaxSize(),
            navController = navController,
            startDestination = AppNavigationRoute.Home,
            enterTransition = { fadeIn(animationSpec = tween(100)) },
            exitTransition = { fadeOut(animationSpec = tween(100)) },
            popEnterTransition = { fadeIn(animationSpec = tween(100)) },
            popExitTransition = { fadeOut(animationSpec = tween(100)) }) {
        homeScreenGraph()
        testScreenGraph()
        languageScreenGraph()
    }
}