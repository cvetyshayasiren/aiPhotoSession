package com.cvetyshayasiren.aiphotosession.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvetyshayasiren.aiphotosession.Config
import com.cvetyshayasiren.aiphotosession.data.ImageOpt
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlin.jvm.JvmInline
import kotlin.math.max

object MainViewModel: ViewModel() {
    internal val loadingQueue: MutableStateFlow<Set<ImageOpt>> = MutableStateFlow(ImageOpt.loadSet)
    internal var maxQueueSize = loadingQueue.value.size
        private set

    fun addInLoadingQueue(image: ImageOpt) {
        if(loadingQueue.value.contains(image)) { return }
        loadingQueue.value = loadingQueue.value.plus(image)
        maxQueueSize = max(maxQueueSize, loadingQueue.value.size)
    }

    fun onLoadingSuccess(image: ImageOpt) {
        if(loadingQueue.value.contains(image)) {
            loadingQueue.value = loadingQueue.value.minus(image)
        }
    }
}

fun SharingStarted.Companion.custom(): SharingStarted =
    WhileSubscribed(stopTimeoutMillis = 5000, replayExpirationMillis = 5000)

fun MainViewModel.isReady(
    scope: CoroutineScope = viewModelScope,
    started: SharingStarted = SharingStarted.custom()
): StateFlow<Boolean> =
    loadingQueue.map { imageOpts ->
        imageOpts.isEmpty()
    }.stateIn(
        scope = scope,
        started = started,
        initialValue = false
    )

fun MainViewModel.progress(
    scope: CoroutineScope = viewModelScope,
    started: SharingStarted = SharingStarted.custom()
): StateFlow<ProgressLoading> =
    loadingQueue.map { imageOpts ->
        ProgressLoading(
            fraction = 1f - (imageOpts.size.toFloat() / maxQueueSize)
                .let { remains -> if(remains.isFinite()) remains else 0f }.coerceIn(0f, 1f)
        )
    }.stateIn(
        scope = scope,
        started = started,
        initialValue = ProgressLoading.Zero
    )

@OptIn(FlowPreview::class)
fun MainViewModel.progressPhrases(
    scope: CoroutineScope = viewModelScope,
    started: SharingStarted = SharingStarted.custom()
): StateFlow<String> =
    progress(scope = scope, started = started)
        .sample(500)
        .map { progress ->
            when(progress.fraction) {
                1f -> "ну вот и всё"
                in(0f.. .85f) -> Config.loadingPhrases.random()
                in(.85f..1f) -> Config.almostLoadingPhrases.random()
                else -> "..."
            }
        }
        .stateIn(
            scope = scope,
            started = started,
            initialValue = Config.loadingPhrases.random()
        )

@JvmInline
value class ProgressLoading(
    val fraction: Float = 0f
) {
    fun toPercent(): Int = (fraction * 100).toInt()
    fun prettyPercent(): String = "${toPercent()}%"

    companion object {
        val Zero = ProgressLoading(fraction = 0f)
    }
}