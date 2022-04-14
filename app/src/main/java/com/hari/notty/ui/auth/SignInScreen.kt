package com.hari.notty.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.hari.notty.R
import com.hari.notty.ui.components.NottyTextField
import com.hari.notty.ui.theme.Blue
import com.hari.notty.ui.theme.Facebook
import com.hari.notty.ui.theme.Google
import com.hari.notty.ui.theme.NottyGray
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination()
@Composable
fun SignInScreen(
    navigator: DestinationsNavigator
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailLeadingIconTint by remember { mutableStateOf(NottyGray.copy(alpha = 0.38f)) }
    var passwordLeadingIconTint by remember { mutableStateOf(NottyGray.copy(alpha = 0.38f)) }

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier.padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.ic_notebook),
            contentDescription = "Welcome Image"
        )

        Spacer(modifier = Modifier.height(30.dp))

        NottyTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .onFocusChanged { focusState: FocusState ->
                    emailLeadingIconTint = if (focusState.isFocused) {
                        Blue
                    } else {
                        NottyGray.copy(alpha = .38f)
                    }
                },
            value = email,
            onValueChange = { email = it },
            label = stringResource(R.string.email),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_email_24),
                    contentDescription = "",
                    tint = emailLeadingIconTint
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        NottyTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .onFocusChanged { focusState: FocusState ->
                    passwordLeadingIconTint = if (focusState.isFocused) {
                        Blue
                    } else {
                        NottyGray.copy(alpha = .38f)
                    }
                },
            value = password,
            onValueChange = { password = it },
            label = stringResource(R.string.password),
            singleLine = true,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_lock_open_24),
                    contentDescription = "",
                    tint = passwordLeadingIconTint
                )
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        imageVector = image,
                        contentDescription = "",
                        tint = passwordLeadingIconTint
                    )
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { }) {
                Text("Forget Password?", color = Blue)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier.width(200.dp),
            onClick = { },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(vertical = 5.dp),
                style = MaterialTheme.typography.button.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                onClick = { },
                modifier = Modifier
                    .then(Modifier.size(50.dp))
                    .background(Facebook, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook button",
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.size(8.dp))

            IconButton(
                onClick = { },
                modifier = Modifier
                    .then(Modifier.size(50.dp))
                    .background(Google, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google button",
                    tint = Color.White
                )
            }

        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Don't have an account?",
                style = MaterialTheme.typography.body2.copy(color = Color.Gray)
            )

            TextButton(onClick = { }) {
                Text("Signup", color = Blue)
            }

        }

    }
}

