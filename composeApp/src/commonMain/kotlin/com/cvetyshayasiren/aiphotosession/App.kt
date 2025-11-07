package com.cvetyshayasiren.aiphotosession

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.cvetyshayasiren.aiphotosession.ui.MainScreenView
import com.cvetyshayasiren.aiphotosession.ui.ThemeSwitcherView
import com.cvetyshayasiren.aiphotosession.ui.theme.AiPhotoSessionExpressiveTheme
import com.cvetyshayasiren.aiphotosession.ui.theme.ThemeState
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