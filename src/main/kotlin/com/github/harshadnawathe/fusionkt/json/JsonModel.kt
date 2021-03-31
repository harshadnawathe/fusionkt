package com.github.harshadnawathe.fusionkt.json

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class JsonModel<T>(
    private val type: Class<T>,
    private val json: JsonNode
) {

    val value : T by lazy {
        mapper.convertValue(json, type)
    }

    companion object {
        val mapper = jacksonObjectMapper()

        inline fun <reified T> from(value: T): JsonModel<T> {
            return JsonModel(
                type = T::class.java,
                json = mapper.valueToTree(value)
            )
        }
    }
}
