package com.hari.notty.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hari.notty.ui.theme.NottyF6
import com.hari.notty.ui.theme.NottyGray

@Composable
fun NottyTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
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