package com.hari.notty.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun NoteCardComponent() {
    Card(
        backgroundColor = MaterialTheme.colors.surface,
        shape = RoundedCornerShape(10.dp),
        elevation = 6.dp,
    ) {
        ConstraintLayout(modifier = Modifier.padding(10.dp)) {
            val (title, description, tag, date) = createRefs()

            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                text = "Design basics",
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier.constrainAs(description) {
                    top.linkTo(title.bottom)
                    start.linkTo(parent.start)
                },
                text = "The fundamental principles of design are Emphasis, Balance and Alignment, Contrast, Repetition, Proportion, Movement and White Space. The fundamental principles of design are Emphasis, Balance and Alignment, Contrast, Repetition, Proportion, Movement and White Space. ",
                style = MaterialTheme.typography.body2
            )
        }
    }

}