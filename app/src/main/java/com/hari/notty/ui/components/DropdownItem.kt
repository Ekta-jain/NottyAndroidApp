package com.hari.notty.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun DropdownItem(
    label: String,
    icon: ImageVector? = null,
    iconTint: Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        icon?.let {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = it,
                contentDescription = label,
                tint = iconTint
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
        Text(label)
    }
}