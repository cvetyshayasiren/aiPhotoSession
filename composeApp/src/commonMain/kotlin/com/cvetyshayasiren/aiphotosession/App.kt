package com.cvetyshayasiren.aiphotosession

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        val scrollState = rememberScrollState()
        Surface(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                MainScreenView(modifier = Modifier.verticalScroll(scrollState))
                ThemeSwitcherView(
                    modifier = Modifier.align(Alignment.TopEnd)
                )
                VerticalScrollbar(
                    adapter = rememberScrollbarAdapter(scrollState),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .fillMaxHeight()
                )
            }
        }
    }
}