package com.github.harshadnawathe.fusionkt.json

class JsonModel<T>(val value: T) {

    companion object {
        inline fun <reified T> from(value: T): JsonModel<T> {
            return JsonModel(value)
        }
    }
}
