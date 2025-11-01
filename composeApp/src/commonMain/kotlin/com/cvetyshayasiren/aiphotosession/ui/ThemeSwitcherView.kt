package com.cvetyshayasiren.aiphotosession.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.cvetyshayasiren.aiphotosession.ui.theme.ThemeState

@Composable
fun ThemeSwitcherView(
    modifier: Modifier = Modifier
) {
    val state = ThemeState.state.collectAsState()
    IconButton(
        modifier = modifier,
        onClick = {
            ThemeState.switch()
        }
    ) {
        Icon(
            imageVector = state.value.icon,
            contentDescription = "theme mode icon ${state.value.label}"
        )
    }
}