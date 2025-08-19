package com.example.instadev.view.auth.register

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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instadev.R

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth()
            )
            {
                Icon(
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .size(35.dp),
                    painter = painterResource(id = R.drawable.ic_back_page),
                    contentDescription = "Back page",
                    tint = Color.White
                )
            }
            Spacer(Modifier.height(10.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.register_screen_header_text_question),
                fontSize = 25.sp,
                color = Color.White
            )
            Spacer(Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.register_screen_text_message_informative_first),
                lineHeight = 20.sp
            )
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = "",
                shape = RoundedCornerShape(30),
                onValueChange = {},
                label = {
                    Text(
                        text = stringResource(id = R.string.register_screen_textfield_telephone_number)
                    )
                }
            )
            Spacer(Modifier.height(20.dp))
            Text(
                modifier = Modifier,
                fontSize = 13.sp,
                lineHeight = 15.sp,
                text = stringResource(
                    id = R.string.register_screen_text_message_informative_second
                )
            )
            Spacer(Modifier.height(20.dp))
            Button(
                modifier = modifier
                    .fillMaxWidth(),
                onClick = {}
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 5.dp),
                    text = stringResource(
                        id = R.string.register_screen_button_text_next
                    )
                )
            }
            Spacer(Modifier.height(5.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {}
            ) {
                Text(
                    text = stringResource(id = R.string.register_screen_button_text_change_email)
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                modifier = Modifier
                    .padding(bottom = 15.dp),
                text = stringResource(id = R.string.register_screen_text_find_account)
            )
        }
    }
}