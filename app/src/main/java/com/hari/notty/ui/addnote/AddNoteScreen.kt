package com.hari.notty.ui.addnote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination()
@Composable
fun AddNoteScreen(
    navigator: DestinationsNavigator,
    noteId: String
) {
    val scrollState = rememberScrollState()
    val text = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .navigationBarsPadding()
            .verticalScroll(scrollState)
    ) {
        AddNoteHeader()
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text.value,
            onValueChange = { text.value = it },
            label = {
                Text(
                    text = "Title",
                    color = MaterialTheme.colors.onSurface
                )
            }
        )
        Spacer(modifier = Modifier.size(16.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            value = text.value,
            onValueChange = {},
            label = {
                Text(
                    text = "Add note here...",
                    color = MaterialTheme.colors.onSurface
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = MaterialTheme.colors.onSurface,
                unfocusedLabelColor = MaterialTheme.colors.onSurface,
            )
        )
    }


}

@Composable
fun AddNoteHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "15/01 11:00 AM",
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.size(4.dp))
            IconButton(
                onClick = { },
                modifier = Modifier.size(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.EditCalendar,
                    contentDescription = "Change Date"
                )
            }
        }


        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Tag",
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.size(4.dp))
            IconButton(
                onClick = { },
                modifier = Modifier.size(16.dp)
            ) {
                Icon(imageVector = Icons.Rounded.Category, contentDescription = "Change Tag")
            }
        }


    }
}