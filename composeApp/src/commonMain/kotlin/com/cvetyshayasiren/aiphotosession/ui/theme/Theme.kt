package com.cvetyshayasiren.aiphotosession.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.DarkMode
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.materialkolor.DynamicMaterialTheme
import com.materialkolor.PaletteStyle
import com.materialkolor.dynamiccolor.ColorSpec
import com.materialkolor.rememberDynamicMaterialThemeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class ThemeMode(
    val label: String,
    val icon: ImageVector
) {
    DARK(label = "тёмная", icon = Icons.Rounded.DarkMode),
    LIGHT(label = "светлая", icon = Icons.Rounded.LightMode);
    fun isDark(): Boolean = this == DARK
    fun switch(): ThemeMode = if(isDark()) LIGHT else DARK

    companion object {
        fun fromBoolean(isDark: Boolean) = if(isDark) DARK else LIGHT
    }
}

object ThemeState: ViewModel() {
    private val _state: MutableStateFlow<ThemeMode> = MutableStateFlow(ThemeMode.DARK)
    val state: StateFlow<ThemeMode> = _state.asStateFlow()
    fun switch() = setState(_state.value.switch())
    fun setState(mode: ThemeMode) { _state.value = mode }
    fun setState(isDark: Boolean) = setState(ThemeMode.fromBoolean(isDark))
}

@Composable
fun AiPhotoSessionExpressiveTheme(
    content: @Composable () -> Unit
) {
    val state = ThemeState.state.collectAsState()

    val dynamicThemeState = rememberDynamicMaterialThemeState(
        isDark = state.value.isDark(),
        style = PaletteStyle.Vibrant,
        specVersion = ColorSpec.SpecVersion.SPEC_2025,
        seedColor = Color(82, 92, 120),
    )

    DynamicMaterialTheme(
        state = dynamicThemeState,
        animate = true,
        content = content,
    )
}