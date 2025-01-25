package com.teegarcs.legacysample

sealed class MainIntent {
    data object Increment : MainIntent()
    data object Decrement : MainIntent()
}