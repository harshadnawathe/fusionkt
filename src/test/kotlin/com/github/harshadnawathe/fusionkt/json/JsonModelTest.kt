package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelTest {

    @Test
    fun `should construct a JsonModel with given value`() {
        val model = JsonModel.from(Single("Kryptonite"))

        model.value shouldBe Single("Kryptonite")
    }
}

internal data class Single(
    val value: String
)