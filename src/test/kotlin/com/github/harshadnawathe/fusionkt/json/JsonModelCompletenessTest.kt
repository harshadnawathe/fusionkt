package com.github.harshadnawathe.fusionkt.json

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JsonModelCompletenessTest {

    @Test
    fun `should return true when JsonModel is complete`() {
        val model = JsonModel.from(Pair("Robin", "Damian Wayne"))

        val isComplete: Boolean = model.isComplete

        isComplete shouldBe true
    }

    @Test
    fun `should return false when JsonModel is not complete`() {
        val model = JsonModel.from<Pair>(
            jsonText = "{ \"key\": \"Robin\" }"
        )

        val isComplete: Boolean = model.isComplete

        isComplete shouldBe false
    }
}