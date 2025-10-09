package com.emanh.flashcard.topicenglish.persentation.ui.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.emanh.common.composable.AnimationCommon
import com.emanh.common.composable.theme.ColorCommon
import com.emanh.common.composable.theme.TextStyleCommon
import com.emanh.flashcard.topicenglish.R

@Composable
fun TestScreen() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        AnimationCommon(modifier = Modifier
            .fillMaxWidth()
            .height(height = 144.dp)
            .padding(horizontal = 40.dp), assetName = "welcome.lottie")
        Text(text = stringResource(id = R.string.welcome), style = TextStyleCommon.LabelMediumMedium14, color = ColorCommon.Gray25)
    }
}