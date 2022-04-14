package com.hari.notty.ui.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.systemBarsPadding
import com.hari.notty.R
import com.hari.notty.ui.components.NottyTextField
import com.hari.notty.ui.theme.Blue
import com.hari.notty.ui.theme.NottyGray
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun SignUpScreen(
    navigator: DestinationsNavigator
) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var fullNameLeadingIconTint by remember { mutableStateOf(NottyGray.copy(alpha = 0.38f)) }
    var emailLeadingIconTint by remember { mutableStateOf(NottyGray.copy(alpha = 0.38f)) }
    var passwordLeadingIconTint by remember { mutableStateOf(NottyGray.copy(alpha = 0.38f)) }

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

    val termsAndPrivacyAnnotatedString = buildAnnotatedString {
        append("By signing up, you're agree to our ")
        pushStringAnnotation(
            tag = "Terms & Condition",// provide tag which will then be provided when you click the text
            annotation = "Terms & Condition"
        )
        withStyle(style = SpanStyle(Blue)) {
            append("Terms & Condition")
        }

        pop()

        append(" and ")

        pushStringAnnotation(
            tag = "Privacy Policy",// provide tag which will then be provided when you click the text
            annotation = "Privacy Policy"
        )
        withStyle(style = SpanStyle(Blue)) {
            append("Privacy Policy")
        }
        pop()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
            ,
            painter = painterResource(id = R.drawable.ic_happy_feeling),
            contentDescription = "Welcome Image"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            text = stringResource(id = R.string.sing_up),
            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.ExtraBold)
        )

        Spacer(modifier = Modifier.height(20.dp))

        NottyTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .onFocusChanged { focusState: FocusState ->
                    fullNameLeadingIconTint = if (focusState.isFocused) {
                        Blue
                    } else {
                        NottyGray.copy(alpha = .38f)
                    }
                },
            value = fullName,
            onValueChange = { fullName = it },
            label = stringResource(R.string.full_name),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_person_24),
                    contentDescription = "",
                    tint = fullNameLeadingIconTint
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

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

        Spacer(modifier = Modifier.height(20.dp))

        ClickableText(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            text = termsAndPrivacyAnnotatedString,
            style = MaterialTheme.typography.subtitle2,
            onClick = {offset ->
                termsAndPrivacyAnnotatedString.getStringAnnotations(
                    tag = "Terms & Condition",// tag which you used in the buildAnnotatedString
                    start = offset,
                    end = offset
                )[0].let { annotation ->
                    //do your stuff when it gets clicked
                    Log.d("Clicked", annotation.item)
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

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
                text = "Signup",
                modifier = Modifier.padding(vertical = 5.dp),
                style = MaterialTheme.typography.button.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Joined us before?",
                style = MaterialTheme.typography.body2.copy(color = Color.Gray)
            )

            TextButton(onClick = { }) {
                Text("SignIn", color = Blue)
            }

        }

    }
}

