package com.emanh.flashcard.topicenglish.persentation.ui.home

import androidx.lifecycle.ViewModel
import com.emanh.common.composable.navigation.NavigationController.navigateTo
import com.emanh.common.composable.navigation.navigator.AppNavigator
import com.emanh.flashcard.topicenglish.persentation.navigation.LanguageScreenNavigation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val appNavigator: AppNavigator,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onClick() {
        appNavigator.getNavController().navigateTo(route = LanguageScreenNavigation.getRoute())
    }

    fun onValueChange(value: String) {
        _uiState.value = _uiState.value.copy(value = value)
    }
}