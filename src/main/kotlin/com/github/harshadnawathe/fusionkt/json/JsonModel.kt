package com.github.harshadnawathe.fusionkt.json

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.io.File

class JsonModel<T>(
    private val type: TypeReference<T>,
    private val json: JsonNode
) {

    val isComplete: Boolean
        get() = true

    val value: T by lazy {
        mapper.convertValue(json, type)
    }

    infix fun with(override: Any): JsonModel<T> {
        return when (override) {
            is JsonModel<*> -> this with override.json
            else -> JsonModel(
                type = type,
                json = mapper.updateValue(json, override)
            )
        }
    }

    companion object {
        val mapper = jacksonObjectMapper()

        inline fun <reified T> of(): JsonModel<T> {
            return JsonModel(
                type = jacksonTypeRef(),
                json = mapper.createObjectNode()
            )
        }

        inline fun <reified T> from(value: T): JsonModel<T> {
            return JsonModel(
                type = jacksonTypeRef(),
                json = mapper.valueToTree(value)
            )
        }

        inline fun <reified T> from(jsonText: String): JsonModel<T> {
            return JsonModel(
                type = jacksonTypeRef(),
                json = mapper.readTree(jsonText)
            )
        }

        inline fun <reified T> from(file: File): JsonModel<T> {
            return JsonModel(
                type = jacksonTypeRef(),
                json = mapper.readTree(file)
            )
        }
    }
}
