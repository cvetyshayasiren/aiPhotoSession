package com.cvetyshayasiren.aiphotosession.ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.ui.theme.PaletteState
import com.cvetyshayasiren.aiphotosession.ui.theme.ThemeState

@Composable
fun ThemeSwitcherWidget(
    modifier: Modifier = Modifier
) {
    val state = ThemeState.state.collectAsState()

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement
            .spacedBy(Config.smallPadding, alignment = Alignment.CenterHorizontally)
    ) {
        IconButton(
            modifier = modifier,
            onClick = {
                PaletteState.switchRandom()
            }
        ) {
            Icon(
                imageVector = Icons.Outlined.Palette,
                contentDescription = "palette mode icon ${state.value.label}"
            )
        }
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
}