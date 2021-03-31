package com.github.harshadnawathe.fusionkt.json

internal class Empty{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}

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