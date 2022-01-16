package com.hari.notty

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.hari.notty.ui.NavGraphs
import com.hari.notty.ui.components.AddNoteFloatingButton
import com.hari.notty.ui.components.NottyDrawer
import com.hari.notty.ui.components.NottyScaffold
import com.hari.notty.ui.components.NottyTopAppBar
import com.hari.notty.ui.theme.NottyTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import kotlinx.coroutines.CoroutineScope


@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun NottyApp(
    scaffoldState: ScaffoldState,
    coroutineScope: CoroutineScope
) {
    NottyTheme {
        val navController = rememberAnimatedNavController()
        val navHostEngine = rememberAnimatedNavHostEngine()

        NottyScaffold(
            scaffoldState = scaffoldState,
            navController = navController,
            topBar = { destination ->
                NottyTopAppBar(
                    destination = destination,
                    navController = navController,
                    coroutineScope = coroutineScope,
                    scaffoldState = scaffoldState
                )
            },
            drawerContent = { destination ->
                NottyDrawer(
                    destination = destination,
                    navController = navController,
                    coroutineScope = coroutineScope,
                    scaffoldState = scaffoldState
                )
            },
            floatingActionButton = { destination ->
                AddNoteFloatingButton(
                    destination,
                    navController
                )
            },
        ) {
            DestinationsNavHost(
                navGraph = NavGraphs.root,
                engine = navHostEngine,
                navController = navController,
                modifier = Modifier.padding(it)
            )
        }
    }
}