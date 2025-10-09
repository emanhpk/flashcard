package com.emanh.flashcard.topicenglish.persentation.navigation.route

import kotlinx.serialization.Serializable

@Serializable
sealed class AppNavigationRoute {

    @Serializable
    data object Home : AppNavigationRoute()

    @Serializable
    data object Test : AppNavigationRoute()

    @Serializable
    data object Language : AppNavigationRoute()
}