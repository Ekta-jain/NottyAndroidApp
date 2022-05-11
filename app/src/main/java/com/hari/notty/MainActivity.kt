package com.hari.notty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.insets.ProvideWindowInsets
import com.hari.notty.core.database.NottyDatabase
import com.hari.notty.core.database.entity.NoteEntity
import com.hari.notty.core.database.model.NoteDatabase
import com.hari.notty.core.network.AuthRemoteDataSourceImpl
import com.hari.notty.core.network.model.AuthRemoteDataSource
import com.hari.notty.core.network.request.LoginRequestDto
import com.hari.notty.ui.components.BackPressHandler
import com.hari.notty.ui.components.LocalBackPressedDispatcher
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {

    /*@Inject
    lateinit var database:NoteDatabase*/

    @Inject
    lateinit var authRemoteDataSource: AuthRemoteDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
           // database.insertNote(NoteEntity(1))
            launch(Dispatchers.IO) {
                val response =  authRemoteDataSource.login(LoginRequestDto(email = "harikuhari@gmail.com", password = "123456"))
                print(response.accessToken.token)
            }

        }



        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets(consumeWindowInsets = true) {
                CompositionLocalProvider(
                    LocalBackPressedDispatcher provides this.onBackPressedDispatcher
                ) {
                    val scaffoldState = rememberScaffoldState()
                    val coroutineScope = rememberCoroutineScope()

                    if (scaffoldState.drawerState.isOpen) {
                        BackPressHandler {
                            coroutineScope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    }

                    NottyApp(
                        scaffoldState,
                        coroutineScope
                    )
                }
            }
        }
    }
}