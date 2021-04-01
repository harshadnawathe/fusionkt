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

    @Test
    fun `should construct a JsonModel with single field`() {
        val model = JsonModel.of<Single> {
            "value" having "Kryptonite"
        }

        val actualValue = model.value

        actualValue shouldBe Single("Kryptonite")
    }

    @Test
    fun `should construct a JsonModel with a nested field`() {
        val model = JsonModel.of<Generic<Pair>> {
            "value" having obj {
                "key" having "Superman"
                "value" having "Clark Kent"
            }
        }

        val actualValue = model.value

        actualValue shouldBe Generic(Pair("Superman", "Clark Kent"))
    }

    @Test
    fun `should construct a JsonModel with a null field`() {
        val model = JsonModel.of<Generic<Pair>> {
            "value" having null
        }

        val actualValue = model.value

        actualValue shouldBe Generic<Single>(null)
    }

    @Test
    fun `should construct a JsonModel with array field`() {
        val model = JsonModel.of<Generic<List<String>>> {
            "value" having array[
                    "a", "b"
            ]
        }

        val actualValue = model.value

        actualValue shouldBe Generic(listOf("a", "b"))
    }

    @Test
    fun `should construct a JsonModel with array field containing null elements`() {
        val model = JsonModel.of<Generic<List<String>>> {
            "value" having array[
                    "a", null
            ]
        }

        val actualValue = model.value

        actualValue shouldBe Generic(listOf("a", null))
    }
}


