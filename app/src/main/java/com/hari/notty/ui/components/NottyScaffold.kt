package com.hari.notty.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hari.notty.ui.theme.NottyTheme


@Composable
fun NottyScaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onProfileClicked: (String) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    NottyTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = { NottyDrawer() },
            content = content
        )
    }
}



@Preview
@Composable
fun ScaffoldPreview() {
    NottyScaffold(onProfileClicked = {}) {
        
    }
}