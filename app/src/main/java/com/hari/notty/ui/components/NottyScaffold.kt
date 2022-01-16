package com.hari.notty.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hari.notty.ui.NavGraphs
import com.hari.notty.ui.destinations.Destination
import com.hari.notty.ui.destinations.TypedDestination
import com.hari.notty.ui.navDestination

fun ArrayDeque<NavBackStackEntry>.print(prefix: String = "stack") {
    val stack = toMutableList()
        .filter { it.destination.route !in listOf(NavGraphs.root.route, NavGraphs.root.route) }
        .map { it.navDestination?.javaClass?.simpleName + "@" + it.toString().split("@")[1] }
        .toTypedArray().contentToString()
    println("$prefix = $stack")
}


@Composable
fun NottyScaffold(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    topBar: @Composable (Destination) -> Unit,
    drawerContent: @Composable ColumnScope.(Destination) -> Unit,
    floatingActionButton: @Composable (Destination) -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
    val destination: TypedDestination<out Any?> =
        currentBackStackEntryAsState?.navDestination ?: NavGraphs.root.startDestination

    navController.backQueue.print()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { topBar(destination) },
        drawerContent = { drawerContent(destination) },
        floatingActionButton = { floatingActionButton(destination) },
        content = content
    )

}