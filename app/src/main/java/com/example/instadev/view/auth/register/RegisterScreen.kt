@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.instadev.view.auth.register

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaButton
import com.example.instadev.view.core.components.InstaButtonSecondary
import com.example.instadev.view.core.components.InstaText
import com.example.instadev.view.core.components.InstaTextField

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = hiltViewModel(),
                   navigateBack:() -> Unit
) {

    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val subtitle: String
    val label: String
    val changeModeTitle: String
    when (uiState.isPhoneMode) {
        true -> {
            title = stringResource(R.string.register_screen_title_phone)
            subtitle = stringResource(R.string.register_screen_subtitle_phone)
            label = stringResource(R.string.register_screen_textfield_register_phone)
            changeModeTitle = stringResource(R.string.register_screen_button_register_with_email)
        }

        false -> {
            title = stringResource(R.string.register_screen_title_email)
            subtitle = stringResource(R.string.register_screen_subtitle_email)
            label = stringResource(R.string.register_screen_textfield_register_email)
            changeModeTitle = stringResource(R.string.register_screen_button_register_with_phone)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {},
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back_page),
                        contentDescription = "Back page",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.clickable{navigateBack()}
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedContent(title) { animatedTitle ->
                InstaText(
                    modifier = Modifier.fillMaxWidth(),
                    text = animatedTitle,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(Modifier.height(8.dp))
            InstaText(
                text = subtitle,

                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(16.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.value,
                onValueChange = { registerViewModel.onRegisterChanged(it)},
                label = label
            )
            Spacer(Modifier.height(12.dp))
            InstaText(
                modifier = Modifier,
                text = stringResource(
                    id = R.string.register_screen_text_message_informative_second
                )
            )
            Spacer(Modifier.height(12.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                text = stringResource(R.string.register_screen_button_text_next),
                enabled = uiState.isRegisterEnabled
            )
            Spacer(Modifier.height(5.dp))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClickAction = {registerViewModel.onChangeMode()},
                title = changeModeTitle,
                tittleColor = MaterialTheme.colorScheme.onPrimary,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            )
            Spacer(Modifier.weight(1f))
            InstaText(
                modifier = Modifier
                    .padding(bottom = 15.dp),
                text = stringResource(id = R.string.register_screen_text_find_account),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}