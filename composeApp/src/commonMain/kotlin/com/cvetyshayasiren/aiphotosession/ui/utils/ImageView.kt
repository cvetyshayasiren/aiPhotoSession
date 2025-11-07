package com.cvetyshayasiren.aiphotosession.ui.utils

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.github.panpf.sketch.PainterState
import com.github.panpf.sketch.SubcomposeAsyncImage
import org.jetbrains.skia.svg.SVGPreserveAspectRatio

@Composable
fun ImageView(
    modifier: Modifier = Modifier,
    image: ImageOpt,
    aspectRatio: Float? = null,
    contentScale: ContentScale = ContentScale.Fit,
    colorFilter: ColorFilter? = null
) {
    val aspectRatio = remember { aspectRatio ?: image.getRatio() }
    SubcomposeAsyncImage(
        modifier = modifier
            .animated()
            .aspectRatio(aspectRatio),
        uri = image.getUri(),
        contentDescription = "photo",
        content = {
            AnimatedContent(
                targetState = state.painterState
            ) {
                when (it) {
                    is PainterState.Loading -> {
                        Box(
                            modifier = Modifier.background(MaterialTheme.colorScheme.surfaceBright),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Ща загрузим фоточку, погоди браток")
                        }
                    }
                    is PainterState.Error -> {
                        Box(
                            modifier = Modifier.background(MaterialTheme.colorScheme.error),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("чёт какато ошибка браток")
                        }
                    }
                    else -> {
                        Image(
                            painter = painter,
                            contentDescription = "photo",
                            contentScale = contentScale,
                            colorFilter = colorFilter
                        )
                    }
                }
            }
        }
    )
}