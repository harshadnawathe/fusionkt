package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelMergeTest {
    @Test
    fun `should return value with overrides`() {
        val basic = JsonModel.from(Pair("Robin", "Dick Grayson"))

        val result = basic with Single("Json Todd")

        result.value shouldBe Pair("Robin", "Json Todd")
    }

    @Test
    fun `should accept a JsonModel as an override`() {
        val basic = JsonModel.from(Pair("Robin", "Dick Grayson"))

        val result = basic with JsonModel.from(Single("Json Todd"))

        result.value shouldBe Pair("Robin", "Json Todd")
    }

    @Test
    fun `should combine the model with given value`() {
        val incomplete = JsonModel.from<Pair>(
            jsonText = "{ \"key\": \"Batman\" }"
        )

        val result = incomplete with mapOf("value" to "Bruce Wayne")

        result.value shouldBe Pair("Batman", "Bruce Wayne")
    }
}