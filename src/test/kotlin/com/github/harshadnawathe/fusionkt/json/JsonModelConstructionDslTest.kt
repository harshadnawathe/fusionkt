package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelConstructionDslTest {

    @Test
    fun `should construct an empty JsonModel`() {
        val model = JsonModel.of<Empty> {}

        val actualValue = model.value

        actualValue shouldBe Empty()
    }


}