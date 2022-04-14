package com.hari.notty.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsPadding
import com.hari.notty.R
import com.hari.notty.ui.destinations.AllNoteScreenDestination
import com.hari.notty.ui.destinations.Destination
import com.hari.notty.ui.theme.NottyGray
import com.hari.notty.utils.title
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun NottyTopAppBar(
    destination: Destination,
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        val horizontalPadding: Dp by animateDpAsState(
            if (isAllNoteScreen(destination)) 16.dp else 0.dp
        )

        val verticalPadding: Dp by animateDpAsState(
            if (isAllNoteScreen(destination)) 8.dp else 0.dp
        )

        val profileActionAlpha: Float by animateFloatAsState(
            if (isAllNoteScreen(destination)) 1f else 0f
        )

        val cornerRadius by animateIntAsState(if (isAllNoteScreen(destination)) 100 else 0)
        val color by animateColorAsState(if (isAllNoteScreen(destination)) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface)

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                .background(color, RoundedCornerShape(cornerRadius))
        ) {

            val (navigationIcon, title, profileAction) = createRefs()

            AnimatedContent(
                modifier = Modifier.constrainAs(navigationIcon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                targetState = isAllNoteScreen(destination)
            ) { isHomeScreen ->
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            if (isHomeScreen)
                                scaffoldState.drawerState.open()
                            else
                                navController.popBackStack()
                        }
                    }
                ) {
                    Image(
                        imageVector = if (isHomeScreen) Icons.Rounded.Menu else Icons.Rounded.ArrowBack,
                        contentDescription = "Navigation Icon",
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onPrimary)
                    )
                }
            }

            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(navigationIcon.top)
                    bottom.linkTo(navigationIcon.bottom)
                    start.linkTo(navigationIcon.end)
                    end.linkTo(profileAction.start)
                },
                text = stringResource(id = destination.title ?: R.string.app_name),
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center
            )


            IconButton(
                modifier = Modifier
                    .constrainAs(profileAction) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
                    .alpha(profileActionAlpha),
                onClick = {}
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Profile image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .border(1.dp, NottyGray, CircleShape)
                )
            }
        }
    }

}


fun isAllNoteScreen(destination: Destination) =
    destination.route == AllNoteScreenDestination.route