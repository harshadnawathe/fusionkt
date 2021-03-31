package com.github.harshadnawathe.fusionkt.json

internal data class Single(
    val value: String
)

internal data class Generic<T>(
    val value: T
)

internal data class Pair(
    val key: String,
    val value: String
)