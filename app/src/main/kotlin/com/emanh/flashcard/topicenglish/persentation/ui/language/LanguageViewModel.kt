package com.emanh.flashcard.topicenglish.persentation.ui.language

import android.app.Application
import com.emanh.common.composable.language.CommonLanguageViewModel
import com.emanh.common.composable.navigation.NavigationController.navigateTo
import com.emanh.common.composable.navigation.navigator.AppNavigator
import com.emanh.common.di.CommonModule
import com.emanh.common.utils.SharedPreferencesHelper
import com.emanh.flashcard.topicenglish.persentation.navigation.TestScreenNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    application: Application,
    sharedPreferencesHelper: SharedPreferencesHelper,
    private val appNavigator: AppNavigator,
    @CommonModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    @CommonModule.MainDispatcher private val mainDispatcher: CoroutineDispatcher,
) : CommonLanguageViewModel(goToSetting = false,
                            application = application,
                            sharedPreferencesHelper = sharedPreferencesHelper,
                            ioDispatcher = ioDispatcher,
                            mainDispatcher = mainDispatcher) {
    override fun navigateToScreen() {
        appNavigator.getNavController().navigateTo(route = TestScreenNavigation.getRoute())
    }
}