package com.hari.notty.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.hari.notty.ui.theme.NottyTheme


@ExperimentalMaterialApi
@Composable
fun NottyScaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onProfileClicked: () -> Unit,
    onDrawerItemClicked: (DrawerItem) -> Unit,
    onNavIconPressed: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    NottyTheme {
        Scaffold(
            modifier = Modifier.systemBarsPadding(),
            scaffoldState = scaffoldState,
            drawerContent = { NottyDrawer(onProfileClicked,onDrawerItemClicked) },
            content = content,
            topBar = { NottyTopAppBar(onNavIconPressed = onNavIconPressed,onProfileClicked) },

        )
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun ScaffoldPreview() {
    NottyScaffold(onProfileClicked = {}, onNavIconPressed = {}, onDrawerItemClicked = {}) {

    }
}