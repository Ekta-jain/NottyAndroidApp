package com.hari.notty.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsHeight
import com.hari.notty.R
import com.hari.notty.ui.theme.NottyBlack
import com.hari.notty.ui.theme.NottyGray

@ExperimentalMaterialApi
@Composable
fun NottyDrawer() {
    var selectedItem by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .background(color = NottyGray)
            .fillMaxSize()
    ) {
        Spacer(Modifier.statusBarsHeight())
        DrawerHeader()
        DrawerItem.drawerItems.forEachIndexed { index, drawerItem ->
            DrawerItem(
                drawerItem = drawerItem,
                isSelected = selectedItem == index,
                onClickItem = {
                    selectedItem = index
                })
        }
    }

}

@Composable
private fun DrawerHeader() {
    Box(Modifier.padding(16.dp)) {
        Card(
            backgroundColor = NottyBlack,
            shape = CircleShape,
            elevation = 0.dp,
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
                    color = Color.White,
                    style = MaterialTheme.typography.labelMedium
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
    Card(
        modifier = Modifier.padding(end = 16.dp).fillMaxWidth(),
        onClick = { onClickItem.invoke(drawerItem) },
        backgroundColor = if (isSelected) NottyBlack else NottyGray,
        shape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = drawerItem.iconRes),
                contentDescription = "Drawer item icon",
                modifier = Modifier.padding(start = 20.dp, top = 15.dp, bottom = 15.dp, end = 10.dp)
            )
            Text(
                text = stringResource(drawerItem.titleRes),
                color = Color.White,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

data class DrawerItem(
    @DrawableRes val iconRes: Int,
    @StringRes val titleRes: Int,
    val isSelected: Boolean = false
) {
    companion object {
        val drawerItems = mutableListOf(
            DrawerItem(
                iconRes = R.drawable.notes_icon,
                titleRes = R.string.all_notes,
                isSelected = true
            ),
            DrawerItem(
                iconRes = R.drawable.notes_icon,
                titleRes = R.string.reminders
            ),
            DrawerItem(
                iconRes = R.drawable.label_icon,
                titleRes = R.string.labels
            ),
            DrawerItem(
                iconRes = R.drawable.archive_icon,
                titleRes = R.string.archives
            ),
            DrawerItem(
                iconRes = R.drawable.trash_icon,
                titleRes = R.string.trash
            ),
            DrawerItem(
                iconRes = R.drawable.notes_icon,
                titleRes = R.string.dark_theme
            ),
            DrawerItem(
                iconRes = R.drawable.settings_icon,
                titleRes = R.string.settings
            ),
            DrawerItem(
                iconRes = R.drawable.help_icon,
                titleRes = R.string.help_center
            )
        )
    }
}
