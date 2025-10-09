package com.emanh.flashcard.topicenglish.persentation.ui.language

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.emanh.common.composable.language.LanguageItemData
import com.emanh.common.composable.theme.ColorCommon
import com.emanh.common.composable.theme.TextStyleCommon

@Composable
fun LanguageScreen() {
    val viewModel = hiltViewModel<LanguageViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    LanguageScreenStateLess(languageItems = uiState.languageItems, onDoneClick = viewModel::onDoneClick, onSelectedClick = viewModel::onSelectedClick)
}

@Composable
private fun LanguageScreenStateLess(
    modifier: Modifier = Modifier,
    languageItems: List<LanguageItemData>,
    onDoneClick: () -> Unit,
    onSelectedClick: (LanguageItemData) -> Unit,
) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
        .statusBarsPadding()
        .navigationBarsPadding()
        .padding(vertical = 32.dp),
               verticalArrangement = Arrangement.spacedBy(space = 16.dp)) {
        items(languageItems) {
            Box(modifier = Modifier
                .padding(horizontal = 24.dp)
                .clip(shape = RoundedCornerShape(size = 8.dp))
                .background(color = if (it.isSelected) ColorCommon.Blue800 else ColorCommon.Gray900)
                .clickable(onClick = {
                    onSelectedClick(it)
                })) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(space = 8.dp)) {
                    Icon(painter = painterResource(id = it.iconId),
                         contentDescription = null,
                         tint = Color.Unspecified,
                         modifier = Modifier.size(24.dp))
                    Text(text = stringResource(id = it.labelId), style = TextStyleCommon.LabelMediumMedium14, color = ColorCommon.Gray25)
                }
            }
        }

        item {
            Button(onClick = onDoneClick, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)) {
                Text(text = "Done")
            }
        }
    }
}