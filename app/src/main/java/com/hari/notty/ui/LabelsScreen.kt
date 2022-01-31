package com.hari.notty.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hari.notty.R
import com.hari.notty.ui.components.DropdownItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination()
@Composable
fun LabelsScreen(
    navigator: DestinationsNavigator
) {
    val labels = mutableListOf("Home", "Category", "Work", "Shopping")
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(labels.size) { index ->
            LabelItem(
                label = labels[index],
                onClick = {},
                onClickDelete = {

                }
            )
        }
    }
}

@Composable
fun LabelItem(
    modifier: Modifier = Modifier,
    label: String,
    onClick: (() -> Unit)? = null,
    onClickDelete: (() -> Unit)? = null,
    onClickRename: (() -> Unit)? = null,
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        onClick = { onClick?.invoke() }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = label,
                style = MaterialTheme.typography.subtitle2
            )
            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = { expanded = true }
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.options)
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        onClick = {
                            onClickDelete?.invoke()
                            expanded = false
                        }
                    ) {
                        DropdownItem(
                            label = stringResource(R.string.delete),
                            icon = Icons.Default.DeleteOutline,
                            iconTint = MaterialTheme.colors.error
                        )

                    }
                    DropdownMenuItem(
                        onClick = {
                            onClickRename?.invoke()
                            expanded = false
                        }

                    ) {
                        DropdownItem(
                            label = stringResource(R.string.rename),
                            icon = Icons.Default.Edit
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LabelPreview() {
    LabelItem(label = "Home")
}