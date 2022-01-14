package com.hari.notty.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.navigationBarsPadding
import com.hari.notty.ui.theme.Blue
import com.hari.notty.ui.theme.NottyTheme


@ExperimentalMaterialApi
@Composable
fun NottyScaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onProfileClicked: () -> Unit,
    onDrawerItemClicked: (DrawerItem) -> Unit,
    onNavIconPressed: () -> Unit,
    onClickAddNote: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    NottyTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = { NottyDrawer(onProfileClicked, onDrawerItemClicked) },
            topBar = { NottyTopAppBar(onNavIconPressed = onNavIconPressed, onProfileClicked) },
            content = content,
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    modifier = Modifier.navigationBarsPadding(),
                    onClick = onClickAddNote,
                    backgroundColor = Blue,
                    text = { Text(text = "Add Note") },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add Note"
                        )
                    }
                )
            }
        )
    }
}


@ExperimentalMaterialApi
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun ScaffoldDarkPreview() {
    NottyScaffold(
        onProfileClicked = {},
        onNavIconPressed = {},
        onDrawerItemClicked = {},
        onClickAddNote = {}) {

    }
}

@ExperimentalMaterialApi
@Preview(
    name = "Light Mode",
    showBackground = true
)
@Composable
fun ScaffoldPreview() {
    NottyScaffold(
        onProfileClicked = {},
        onNavIconPressed = {},
        onDrawerItemClicked = {},
        onClickAddNote = {}) {

    }
}