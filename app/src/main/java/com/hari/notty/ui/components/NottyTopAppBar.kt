package com.hari.notty.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hari.notty.R
import com.hari.notty.ui.theme.NottyBlack
import com.hari.notty.ui.theme.NottyGray


@Composable
fun NottyTopAppBar(
    onNavIconPressed: () -> Unit = { },
    onProfileClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = NottyBlack
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .background(NottyGray, RoundedCornerShape(100))
        ) {
            val (navigationIcon, title, profileAction) = createRefs()

            IconButton(
                modifier = Modifier.constrainAs(navigationIcon) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                },
                onClick = onNavIconPressed
            ) {
                Image(
                    painter = painterResource(id = R.drawable.hamburger_icon),
                    contentDescription = "Navigation Icon"
                )
            }
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(navigationIcon.top)
                    bottom.linkTo(navigationIcon.bottom)
                    start.linkTo(navigationIcon.end)
                    end.linkTo(profileAction.start)
                },
                text = stringResource(id = R.string.search_from_notes),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                color = Color.White
            )

            IconButton(
                modifier = Modifier.constrainAs(profileAction) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                onClick = onProfileClicked
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