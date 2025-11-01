package com.cvetyshayasiren.aiphotosession.ui

import aiphotosession.composeapp.generated.resources.Res
import aiphotosession.composeapp.generated.resources.compose_multiplatform
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cvetyshayasiren.aiphotosession.getPlatform
import com.github.panpf.sketch.AsyncImage
import com.github.panpf.sketch.rememberAsyncImagePainter
import com.github.panpf.sketch.rememberAsyncImageState
import com.github.panpf.sketch.request.ComposableImageOptions
import com.github.panpf.sketch.request.ComposableImageRequest
import org.jetbrains.compose.resources.painterResource

@Composable
fun MainScreenView(
    modifier: Modifier = Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .safeContentPadding()
        .fillMaxSize()
) {
    val imageUri = remember { "https://i.pinimg.com/736x/a4/a0/76/a4a076280037f157a5e6ebfd19bb30dd.jpg" }
    var showContent by remember { mutableStateOf(false) }
    val platform = remember { getPlatform() }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { showContent = !showContent }) {
            Text("Hello!")
        }
        AnimatedVisibility(showContent) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                AsyncImage(
                    uri = imageUri,
                    contentDescription = "photo"
                )
                Text("Hello AiPhotoSession ${platform.name}")
            }
        }
    }
}