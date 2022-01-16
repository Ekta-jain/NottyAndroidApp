package com.hari.notty.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.google.accompanist.insets.navigationBarsPadding
import com.hari.notty.R
import com.hari.notty.ui.destinations.AddNoteScreenDestination
import com.hari.notty.ui.destinations.Destination
import com.hari.notty.ui.theme.Blue


@Composable
fun AddNoteFloatingButton(
    destination: Destination,
    navController: NavController
) {
    AnimatedVisibility(
        modifier = Modifier.navigationBarsPadding(),
        visible = isAllNoteScreen(destination),
        enter = scaleIn(),
        exit = scaleOut()
    ) {
        ExtendedFloatingActionButton(
            onClick = { navController.navigate(AddNoteScreenDestination.route) },
            backgroundColor = Blue,
            text = { Text(text = stringResource(R.string.add_note)) },
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(R.string.add_note)
                )
            }
        )
    }

}