package com.emanh.flashcard.topicenglish.persentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.emanh.flashcard.topicenglish.persentation.navigation.route.AppNavigationRoute
import com.emanh.flashcard.topicenglish.persentation.ui.language.LanguageScreen
import com.emanh.flashcard.topicenglish.persentation.ui.test.TestScreen

fun NavGraphBuilder.testScreenGraph() {
    composable<AppNavigationRoute.Test> {
        TestScreen()
    }
}

object TestScreenNavigation {
    fun getRoute() = AppNavigationRoute.Test
}

fun NavGraphBuilder.languageScreenGraph() {
    composable<AppNavigationRoute.Language> {
        LanguageScreen()
    }
}

object LanguageScreenNavigation {
    fun getRoute() = AppNavigationRoute.Language
}