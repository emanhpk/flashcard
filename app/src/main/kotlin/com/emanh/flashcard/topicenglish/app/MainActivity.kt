package com.emanh.flashcard.topicenglish.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.emanh.common.composable.navigation.navigator.AppNavigator
import com.emanh.common.utils.SharedPreferencesHelper
import com.emanh.flashcard.topicenglish.persentation.composable.FTEAppNavigation
import com.emanh.flashcard.topicenglish.persentation.theme.FlashcardTopicEnglishTheme
import com.emanh.flashcard.topicenglish.utils.AppUtils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    @Inject
    lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        AppUtils.setImmersiveMode(window)
        setContent {
            val navController = rememberNavController()

            FlashcardTopicEnglishTheme {
                FTEAppNavigation(appNavigator = appNavigator, navController = navController)
            }
        }
    }
}