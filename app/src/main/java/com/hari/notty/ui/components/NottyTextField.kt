package com.hari.notty.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import com.hari.notty.ui.theme.NottyF6
import com.hari.notty.ui.theme.NottyGray

@Composable
fun NottyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    singleLine: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        label = { Text(text = label) },
        leadingIcon = leadingIcon,
        trailingIcon= trailingIcon,
        isError = isError,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.secondary.copy(alpha = ContentAlpha.high),
            unfocusedBorderColor =
            if (isSystemInDarkTheme())
                NottyF6.copy(alpha = ContentAlpha.disabled)
            else
                NottyGray.copy(alpha = ContentAlpha.disabled),
            focusedLabelColor = MaterialTheme.colors.secondary.copy(alpha = ContentAlpha.high),
            unfocusedLabelColor = if (isSystemInDarkTheme())
                NottyF6.copy(alpha = ContentAlpha.disabled)
            else
                NottyGray.copy(alpha = ContentAlpha.disabled),
            cursorColor = if (isSystemInDarkTheme()) NottyF6 else NottyGray
        )
    )
}