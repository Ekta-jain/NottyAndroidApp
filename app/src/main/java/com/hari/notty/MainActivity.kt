package com.hari.notty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import com.hari.notty.ui.components.BackPressHandler
import com.hari.notty.ui.components.LocalBackPressedDispatcher
import com.hari.notty.ui.components.NottyScaffold
import com.hari.notty.ui.theme.NottyBlack
import com.hari.notty.ui.theme.NottyTheme
import kotlinx.coroutines.launch


@ExperimentalMaterial3Api
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
                        onDrawerItemClicked = { drawerItem ->
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    ) {
                        Surface(
                            color = NottyBlack,
                            modifier = Modifier.fillMaxSize()
                        ) {


                        }

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