package com.barteklipinski.testcasefactory.integration

import com.barteklipinski.testcasefactory.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import strikt.api.expectThat
import strikt.assertions.hasSize

@RunWith(JUnit4::class)
class IntegrationTest9 {

    @Test
    fun `library works correctly for nine types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val inputs3 = listOf(1.2f, 2.3f, 3.4f)
        val inputs4 = Fruit.values()
        val input6 = "example"
        val input7 = "example2"
        val inputs8 = listOf('a', 'b', 'c')
        val input9 = "abc"
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and
                    exactlyOrNull(input2) and
                    anyOf(inputs3[0], inputs3[1], inputs3[2]) and
                    anyOf(inputs4) excluding (Fruit.Passionfruit) and
                    anyBoolean() and
                    anyOf(input6) and
                    exactly(input7) and
                    anyOf(inputs8) excluding ('b') excluding ('c') and
                    exactly(input9)
        } expect (expected)

        // then
        val testCasesList = testCases.toList()
        expectThat(testCasesList).hasSize(24)
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            inputSeventh = input7,
            inputEighth = inputs8[0],
            inputNinth = input9,
            expects = expected,
        )
    }
}