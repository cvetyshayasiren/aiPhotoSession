package com.cvetyshayasiren.aiphotosession

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import com.cvetyshayasiren.aiphotosession.ui.main.MainScreenView
import com.cvetyshayasiren.aiphotosession.ui.theme.AiPhotoSessionExpressiveTheme
import com.cvetyshayasiren.aiphotosession.ui.theme.ThemeState
import com.cvetyshayasiren.aiphotosession.ui.utils.WalkingImage
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ThemeState.setState(isSystemInDarkTheme())
    AiPhotoSessionExpressiveTheme {
        Surface(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
        ) {
            MainScreenView()
        }
    }
}