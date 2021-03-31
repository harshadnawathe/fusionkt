package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelTest {

    @Test
    fun `should construct a JsonModel with given value`() {
        val model = JsonModel.from(Single("Kryptonite"))

        model.value shouldBe Single("Kryptonite")
    }

    @Test
    fun `should construct a JsonModel with an instance of a generic`() {
        val model = JsonModel.from(Generic("Batman"))

        val actualValue  = model.value

        actualValue shouldBe Generic("Batman")
    }

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