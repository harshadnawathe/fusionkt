package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelConstructionTest {

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
    fun `should construct an empty JsonModel of a given object type`() {
        val model = JsonModel.of<Empty>()

        val actualValue = model.value

        actualValue shouldBe Empty()
    }
}

