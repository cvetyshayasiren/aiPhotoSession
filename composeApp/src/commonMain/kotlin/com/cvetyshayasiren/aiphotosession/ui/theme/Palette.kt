package com.cvetyshayasiren.aiphotosession.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.materialkolor.PaletteStyle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class PaletteMode(
    val paletteStyle: PaletteStyle,
    val color: Color
) {
    companion object {
        fun init(): PaletteMode = PaletteMode(paletteStyle = PaletteStyle.Vibrant, color = Color(82, 92, 120))
        fun random(): PaletteMode = PaletteMode(paletteStyle = randomPaletteStyle(), color = randomColor())
    }
}

object PaletteState: ViewModel() {
    private val _state: MutableStateFlow<PaletteMode> = MutableStateFlow(PaletteMode.random())
    val state: StateFlow<PaletteMode> = _state.asStateFlow()

    fun switchRandom() { _state.value = PaletteMode.random() }
}

fun randomPaletteStyle(): PaletteStyle = listOf(
    PaletteStyle.Vibrant,
    PaletteStyle.Expressive,
    PaletteStyle.FruitSalad,
    PaletteStyle.Content
).random()

fun randomColor(): Color = listOf(
    Color(82, 92, 120),
    Color(10, 90, 50),
    Color(160, 20, 70),
    Color(200, 200, 100),
).random()