package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView

@Composable
fun ShapesView(
    modifier: Modifier = Modifier,
    photos: List<ImageOpt> = listOf(ImageOpt.DUB_CYBER_0, ImageOpt.DUB_CYBER_1, ImageOpt.VI_CYBER_0, ImageOpt.VI_CYBER_1)
) {
    val shapes = remember { List(photos.size) { getRandomCornerShape() } }

    Row(
        modifier = modifier
    ) {
        photos.forEachIndexed { index, image ->
            ImageView(
                modifier = Modifier
                    .weight(1f)
                    .clip(shapes[index]),
                image = image,
                aspectRatio = 1f
            )
        }
    }
}

fun getRandomCornerShape() = listOf(
    RoundedCornerShape(
        topStart = (0..48).random().dp,
        topEnd = (0..48).random().dp,
        bottomStart = (0..48).random().dp,
        bottomEnd = (0..48).random().dp
    ),
    RoundedCornerShape(0.dp),
    CircleShape
).random()