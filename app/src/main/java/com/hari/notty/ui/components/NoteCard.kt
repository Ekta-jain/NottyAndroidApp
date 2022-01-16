package com.hari.notty.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hari.notty.R
import com.hari.notty.ui.theme.Yellow

@Composable
fun NoteCard(
    onClick: (() -> Unit)? = null
) {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(10.dp),
        elevation = 6.dp,
        onClick = { onClick?.invoke() }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(Yellow)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    modifier = Modifier,
                    text = "Design basics",
                    style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.SemiBold),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(6.dp))
                Text(
                    modifier = Modifier,
                    text = "The fundamental principles of design are Emphasis, Balance and Alignment, Contrast, Repetition, Proportion, Movement and White Space. The fundamental principles of design are Emphasis, Balance and Alignment, Contrast, Repetition, Proportion, Movement and White Space. ",
                    style = MaterialTheme.typography.caption,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.size(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Text(
                        modifier = Modifier
                            .border(BorderStroke(1.dp, Color.Gray), shape = CircleShape)
                            .padding(vertical = 6.dp, horizontal = 10.dp),
                        text = "TO-DO",
                        style = MaterialTheme.typography.overline
                    )

                    Text(
                        text = "June 09",
                        style = MaterialTheme.typography.caption
                    )
                }

            }
        }

    }

}


@Preview(showBackground = true)
@Composable
fun NoteCardPreview() {
    NoteCard()
}

@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun NoteCardDarkPreview() {
    NoteCard()
}