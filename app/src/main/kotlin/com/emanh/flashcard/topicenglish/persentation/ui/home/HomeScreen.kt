package com.emanh.flashcard.topicenglish.persentation.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.emanh.common.R
import com.emanh.common.composable.ButtonCommon
import com.emanh.common.composable.ImageCoilCommon
import com.emanh.common.composable.PaddingButtonCommon
import com.emanh.common.composable.TextFieldCommon
import com.emanh.common.composable.theme.ColorCommon
import com.emanh.common.composable.theme.TextStyleCommon
import com.emanh.flashcard.topicenglish.persentation.theme.FlashcardTopicEnglishTheme

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    HomeScreenStateLess(value = uiState.value, onButtonClick = viewModel::onClick, onValueChange = viewModel::onValueChange)
}

@Composable
private fun HomeScreenStateLess(modifier: Modifier = Modifier, value: String, onButtonClick: () -> Unit, onValueChange: (String) -> Unit) {
    val focusManager = LocalFocusManager.current

    Box(modifier = modifier
        .fillMaxSize()
        .clickable(onClick = {
            focusManager.clearFocus()
        }, interactionSource = remember { MutableInteractionSource() }, indication = null), contentAlignment = Alignment.Center) {
        LazyColumn(modifier = Modifier.padding(24.dp),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.spacedBy(space = 16.dp)) {
            item {
                TextFieldCommon(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                                textFieldModifier = Modifier.padding(horizontal = 8.dp),
                                value = value,
                                placeholder = "placeholder",
                                maxLines = 3,
                                weight = 1f,
                                textStyle = TextStyleCommon.HeadingMediumMedium14,
                                shape = RoundedCornerShape(size = 8.dp),
                                border = BorderStroke(width = 1.dp, color = ColorCommon.Blue600),
                                onValueChange = onValueChange,
                                leadingIcon = {
                                    ButtonCommon(padding = PaddingButtonCommon.padding(padding = 4.dp), onClick = {}) {
                                        Icon(painter = painterResource(id = R.drawable.ic_viet_nam_circle_shape),
                                             contentDescription = null,
                                             tint = Color.Unspecified,
                                             modifier = Modifier.size(24.dp))
                                    }
                                },
                                trailingIcon = {
                                    ButtonCommon(padding = PaddingButtonCommon.padding(padding = 4.dp), onClick = {}) {
                                        Icon(painter = painterResource(id = R.drawable.ic_united_kingdom_circle_shape),
                                             contentDescription = null,
                                             tint = Color.Unspecified,
                                             modifier = Modifier.size(24.dp))
                                    }
                                })
            }

            item {
                ImageCoilCommon(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
                    .aspectRatio(ratio = 1f),
                                model = "https://japanspecialist.com/documents/d/japanspecialist/1_spring_in_japan_body-1",
                                shape = RoundedCornerShape(size = 8.dp),
                                border = BorderStroke(width = 1.dp, color = ColorCommon.Blue600),
                                contentScale = ContentScale.Crop)
            }

            item {
                Button(onClick = onButtonClick) {
                    Text(text = stringResource(id = com.emanh.flashcard.topicenglish.R.string.language))
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    FlashcardTopicEnglishTheme {
        HomeScreenStateLess(value = "", onButtonClick = {}, onValueChange = {})
    }
}