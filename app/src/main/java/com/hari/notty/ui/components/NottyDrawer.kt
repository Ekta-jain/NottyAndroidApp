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
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight
import com.hari.notty.R
import com.hari.notty.ui.theme.NottyGray

@ExperimentalMaterialApi
@Composable
fun NottyDrawer(onProfileClicked: () -> Unit, onDrawerItemClicked: (DrawerItem) -> Unit) {
    var selectedItem by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primary)
            .fillMaxSize()
    ) {
        Spacer(Modifier.statusBarsHeight())
        DrawerHeader(onProfileClicked)
        DrawerItem.values().forEachIndexed { index, drawerItem ->
            DrawerItem(
                drawerItem = drawerItem,
                isSelected = selectedItem == index,
                onClickItem = {
                    selectedItem = index
                    onDrawerItemClicked.invoke(drawerItem)
                })
        }
    }

}

@ExperimentalMaterialApi
@Composable
private fun DrawerHeader(onProfileClicked: () -> Unit) {
    Box(Modifier.padding(16.dp)) {
        Card(
            shape = CircleShape,
            elevation = 0.dp,
            onClick = onProfileClicked,
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