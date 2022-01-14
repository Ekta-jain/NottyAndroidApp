package com.hari.notty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.hari.notty.ui.components.BackPressHandler
import com.hari.notty.ui.components.DrawerItem
import com.hari.notty.ui.components.LocalBackPressedDispatcher
import com.hari.notty.ui.components.NottyScaffold
import com.hari.notty.ui.notes.NavGraphs
import com.hari.notty.ui.theme.NottyTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import kotlinx.coroutines.launch


@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ProvideWindowInsets(consumeWindowInsets = true) {
                CompositionLocalProvider(
                    LocalBackPressedDispatcher provides this.onBackPressedDispatcher
                ) {

                    val scaffoldState = rememberScaffoldState()

                    val drawerOpen by viewModel.drawerShouldBeOpened.collectAsState()
                    if (drawerOpen) {
                        // Open drawer and reset state in VM.
                        LaunchedEffect(Unit) {
                            scaffoldState.drawerState.open()
                            viewModel.resetOpenDrawerAction()
                        }
                    }

                    // Intercepts back navigation when the drawer is open
                    val scope = rememberCoroutineScope()
                    if (scaffoldState.drawerState.isOpen) {
                        BackPressHandler {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    }

                    NottyScaffold(
                        scaffoldState = scaffoldState,
                        onProfileClicked = {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        },
                        onNavIconPressed = {
                            viewModel.openDrawer()
                        },
                        onClickAddNote = {},
                        onDrawerItemClicked = { drawerItem ->
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                            when (drawerItem) {
                                DrawerItem.ALL_NOTES -> {}
                                DrawerItem.REMINDERS -> {}
                                DrawerItem.LABELS -> {}
                                DrawerItem.ARCHIVES -> {}
                                DrawerItem.TRASH -> {}
                                DrawerItem.DARK_THEME -> {}
                                DrawerItem.SETTINGS -> {}
                                DrawerItem.HELP_CENTER -> {}
                            }
                        }
                    ) {
                        DestinationsNavHost(navGraph = NavGraphs.root)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NottyTheme {
        Greeting("Android")
    }
}