package com.cvetyshayasiren.aiphotosession.ui.theme

import aiphotosession.composeapp.generated.resources.Res
import aiphotosession.composeapp.generated.resources.rubik_mono_one_regular
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font

@get:Composable
val rubikMonoOne
    get() = FontFamily(Font(resource = Res.font.rubik_mono_one_regular, FontWeight.Normal))