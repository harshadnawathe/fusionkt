package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.io.File

class JsonModelConstructionTest {

    @Test
    fun `should construct a JsonModel with given value`() {
        val model = JsonModel.from(Single("Kryptonite"))

        model.value shouldBe Single("Kryptonite")
    }

    @Test
    fun `should construct a JsonModel with an instance of a generic`() {
        val model = JsonModel.from(Generic("Batman"))

        val actualValue = model.value

        actualValue shouldBe Generic("Batman")
    }

    @Test
    fun `should construct an empty JsonModel of a given object type`() {
        val model = JsonModel.of<Empty>()

        val actualValue = model.value

        actualValue shouldBe Empty()
    }

    @Test
    fun `should construct a JsonModel from json text`() {
        val model = JsonModel.from<Pair>(
            jsonText = """{
                | "key": "Robin",
                | "value": "Tim Drake"
                |}""".trimMargin()
        )

        val actualValue = model.value

        actualValue shouldBe Pair("Robin", "Tim Drake")
    }

    @Test
    fun `should construct a JsonModel from a File`() {
        val file = ClassLoader.getSystemResource("pair.json")
            .toURI().let { uri ->
                File(uri)
            }
        val model = JsonModel.from<Pair>(file = file)

        val actualValue = model.value

        actualValue shouldBe Pair("Robin", "Stephanie Brown")
    }
}

