package com.cvetyshayasiren.aiphotosession.ui.utils

import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.Config

@Composable
fun Modifier.brutalShadow(
    shadowColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = MaterialTheme.colorScheme.error,
    shape: Shape = Config.smallRoundedShape,
    width: Dp = Config.smallPadding
): Modifier = this then Modifier
    .dropShadow(
        shape = shape,
        shadow = Shadow(
            radius = 0.dp,
            spread = 0.dp,
            color = shadowColor,
            offset = DpOffset(width, width)
        )
    )
    .border(width = width, color = borderColor, shape = shape)