package com.example.instadev.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.instadev.R

@Composable
fun InstaButtonSecondary(
    modifier: Modifier = Modifier, onClickAction: () -> Unit,
    border: BorderStroke = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    title: String,
    tittleColor: Color = MaterialTheme.colorScheme.primary
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClickAction,
        border = border
    ) {
        InstaText(
            text = title,
            color = tittleColor
        )
    }
}