package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.utils.ImageView
import com.github.panpf.sketch.request.ImageOptions

@Composable
fun FourSquareView(
    modifier: Modifier = Modifier,
    photo: ImageOpt = ImageOpt.DUB_NOIR_0
) {
    Column(
        modifier = modifier.aspectRatio(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            ImageView(
                modifier = Modifier.weight(1f),
                image = photo,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.primary,
                    blendMode = BlendMode.Hue
                ),
                aspectRatio = 1f
            )
            ImageView(
                modifier = Modifier.weight(1f),
                image = photo,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.secondary,
                    blendMode = BlendMode.Hue
                ),
                aspectRatio = 1f
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            ImageView(
                modifier = Modifier.weight(1f),
                image = photo,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.tertiary,
                    blendMode = BlendMode.Hue
                ),
                aspectRatio = 1f
            )
            ImageView(
                modifier = Modifier.weight(1f),
                image = photo,
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.error,
                    blendMode = BlendMode.Hue
                ),
                aspectRatio = 1f
            )
        }
    }
}

