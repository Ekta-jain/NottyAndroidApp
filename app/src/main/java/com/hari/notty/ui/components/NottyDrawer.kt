package com.hari.notty.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.insets.statusBarsHeight
import com.hari.notty.R
import com.hari.notty.ui.destinations.Destination
import com.hari.notty.ui.destinations.LabelsScreenDestination
import com.hari.notty.ui.theme.NottyGray
import com.ramcosta.composedestinations.navigation.navigateTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun NottyDrawer(
    destination: Destination,
    navController: NavHostController,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    var selectedItem by rememberSaveable { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxSize()
    ) {
        Spacer(Modifier.statusBarsHeight())
        DrawerHeader(navController)
        Spacer(modifier = Modifier.size(16.dp))
        DrawerItem.values().forEachIndexed { index, drawerItem ->
            DrawerItem(
                drawerItem = drawerItem,
                isSelected = selectedItem == index,
                onClickItem = { item ->
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                        handleDrawerNavigation(item, navController)
                        selectedItem = index
                    }
                }
            )
        }
    }

}

private fun handleDrawerNavigation(
    item: DrawerItem,
    navController: NavHostController
) {
    when (item) {
        DrawerItem.ALL_NOTES -> {
        }
        DrawerItem.REMINDERS -> {
        }
        DrawerItem.LABELS -> {
            navController.navigateTo(LabelsScreenDestination)
        }
        DrawerItem.ARCHIVES -> {
        }
        DrawerItem.TRASH -> {
        }
        DrawerItem.DARK_THEME -> {
        }
        DrawerItem.SETTINGS -> {
        }
        DrawerItem.HELP_CENTER -> {
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun DrawerHeader(navController: NavHostController) {
    Box(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Card(
            shape = CircleShape,
            elevation = 0.dp,
            onClick = {},
            backgroundColor = MaterialTheme.colors.onSurface
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
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
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = "Hari Singh Kulhari",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun DrawerItem(
    drawerItem: DrawerItem,
    isSelected: Boolean = false,
    onClickItem: (DrawerItem) -> Unit
) {

    Row(
        modifier = Modifier
            .padding(end = 16.dp)
            .background(
                if (isSelected) MaterialTheme.colors.onSurface else MaterialTheme.colors.background,
                RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp)
            )
            .clickable(onClick = { onClickItem.invoke(drawerItem) })
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawerItem.iconRes),
            contentDescription = "Drawer item icon",
            modifier = Modifier.padding(start = 20.dp, top = 15.dp, bottom = 15.dp, end = 10.dp)
        )
        Text(
            text = stringResource(drawerItem.titleRes),
            style = MaterialTheme.typography.subtitle1
        )
    }

}

enum class DrawerItem(@DrawableRes val iconRes: Int, @StringRes val titleRes: Int) {
    ALL_NOTES(
        iconRes = R.drawable.notes_icon,
        titleRes = R.string.all_notes
    ),
    REMINDERS(
        iconRes = R.drawable.bell_icon,
        titleRes = R.string.reminders
    ),
    LABELS(
        iconRes = R.drawable.label_icon,
        titleRes = R.string.labels
    ),
    ARCHIVES(
        iconRes = R.drawable.archive_icon,
        titleRes = R.string.archives
    ),
    TRASH(
        iconRes = R.drawable.trash_icon,
        titleRes = R.string.trash
    ),
    DARK_THEME(
        iconRes = R.drawable.notes_icon,
        titleRes = R.string.dark_theme
    ),
    SETTINGS(
        iconRes = R.drawable.settings_icon,
        titleRes = R.string.settings
    ),
    HELP_CENTER(
        iconRes = R.drawable.help_icon,
        titleRes = R.string.help_center
    );
}