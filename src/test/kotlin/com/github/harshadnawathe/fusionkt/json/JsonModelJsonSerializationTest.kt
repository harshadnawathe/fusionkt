package com.github.harshadnawathe.fusionkt.json

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.kotest.assertions.json.shouldEqualJson
import org.junit.jupiter.api.Test

class JsonModelJsonSerializationTest {

    private val mapper = jacksonObjectMapper()

    @Test
    fun `should serialize JsonModel to a json string`() {
        val model = JsonModel.from(Single("Kryptonite"))

        val json = mapper.writeValueAsString(model)

        json shouldEqualJson "{ \"value\": \"Kryptonite\" }"
    }
}