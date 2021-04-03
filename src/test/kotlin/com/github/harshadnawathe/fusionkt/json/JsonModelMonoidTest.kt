package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelMonoidTest {

    @Test
    fun `with is an associative operation`() {
        val first = JsonModel.of<Pair> {
            "key" having "Robin"
        }
        val second = JsonModel.of<Pair> {
            "value" having "Dick Grayson"
        }
        val third = JsonModel.of<Pair> {
            "value" having "Json Todd"
        }

        val result1 = first with (second with third)
        val result2 = (first with second) with third

        result1.value shouldBe result2.value
    }

    @Test
    fun `empty model is an identity element`() {
        val empty = JsonModel.of<Single>()
        val model = JsonModel.from(Single("Kryptonite"))

        val result1 = model with empty
        val result2 = empty with model

        result1.value shouldBe result2.value
    }
}