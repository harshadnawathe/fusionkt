package com.github.harshadnawathe.fusionkt.json

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

class JsonModel<T>(
    private val type: TypeReference<T>,
    private val json: JsonNode
) {

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

        inline fun <reified T> from(value: T): JsonModel<T> {
            return JsonModel(
                type = jacksonTypeRef(),
                json = mapper.valueToTree(value)
            )
        }
    }
}
