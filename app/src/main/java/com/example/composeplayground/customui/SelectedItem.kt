package com.example.composeplayground.customui

import android.graphics.drawable.Icon
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SelectedItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    titleSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    titleWidth: FontWeight = FontWeight.Medium,
    titleColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
    subTitle: String? = null,
    subTitleColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
    borderWidth: Dp = 1.dp,
    borderColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
    borderShape: Shape = RoundedCornerShape(10.dp),
    icon: ImageVector = Icons.Default.CheckCircle,
    iconColor: Color = if (selected) MaterialTheme.colorScheme.primary
    else MaterialTheme.colorScheme.onSurface.copy(alpha = .2f),
    onClick: () -> Unit

) {

    val scaleA = remember {
        Animatable(initialValue = 1f)
    }
    val scaleB = remember {
        Animatable(initialValue = 1f)
    }

    LaunchedEffect(key1 = selected) {
        if (selected) {
            launch {
                scaleA.animateTo(
                    targetValue = .3f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )

                scaleA.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )

            }
            launch {
                scaleB.animateTo(
                    targetValue = .9f,
                    animationSpec = tween(
                        durationMillis = 50
                    )
                )

                scaleB.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
        }
    }

    Column(
        modifier = modifier
            .scale(scale = scaleB.value)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            )
            .clip(borderShape)
            .clickable {
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(8f),
                text = title,
                style = TextStyle(
                    color = titleColor,
                    fontSize = titleSize,
                    fontWeight = titleWidth,

                    ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            IconButton(modifier = Modifier.weight(2f)
                .scale(scale = scaleA.value), onClick = onClick) {
                Icon(
                    imageVector = icon,
                    contentDescription = "SelectableIcon",
                    tint = iconColor
                )
            }
        }
        if (subTitle != null) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 12.dp),
                text = subTitle,
                style = TextStyle(
                    color = subTitleColor
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis

            )
        }

    }
}