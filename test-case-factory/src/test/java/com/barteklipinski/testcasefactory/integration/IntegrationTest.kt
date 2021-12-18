package com.barteklipinski.testcasefactory.integration

import com.barteklipinski.testcasefactory.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import strikt.api.expectThat
import strikt.assertions.any
import strikt.assertions.hasSize
import strikt.assertions.isEqualTo

@RunWith(JUnit4::class)
class IntegrationTest {

    @Test
    fun `library works correctly for one type of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val expected = 124.5f

        // when
        val testCases = combinationsOf { anyOf(inputs1) } expect (expected)

        // then
        val testCasesList = testCases.toList()
        expectThat(testCasesList).hasSize(2)
        expectThat(testCasesList).containsTestCase(inputFirst = inputs1[0], expects = expected)
        expectThat(testCasesList).containsTestCase(inputFirst = inputs1[1], expects = expected)
    }

    @Test
    fun `library works correctly for two types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and exactlyOrNull(input2)
        } expect (expected)

        // then
        val testCasesList = testCases.toList()
        expectThat(testCasesList).hasSize(4)
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            expects = expected,
        )
    }

    @Test
    fun `library works correctly for two types of inputs with a mapped input type`() {
        // given
        data class InputWithNames(
            val name1: Int,
            val name2: String?,
        )

        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and exactlyOrNull(input2)
        } mappedTo {
            InputWithNames(it.first, it.second)
        } expect (expected)

        // then
        val testCasesList = testCases.toList()
        expectThat(testCasesList).hasSize(4)
        expectThat(testCasesList).any {
            get { input.name1 }.isEqualTo(inputs1[0])
            get { input.name2 }.isEqualTo(input2)
            get { expected }.isEqualTo(expected)
        }
        expectThat(testCasesList).any {
            get { input.name1 }.isEqualTo(inputs1[0])
            get { input.name2 }.isEqualTo(null)
            get { expected }.isEqualTo(expected)
        }
        expectThat(testCasesList).any {
            get { input.name1 }.isEqualTo(inputs1[1])
            get { input.name2 }.isEqualTo(input2)
            get { expected }.isEqualTo(expected)
        }
        expectThat(testCasesList).any {
            get { input.name1 }.isEqualTo(inputs1[1])
            get { input.name2 }.isEqualTo(null)
            get { expected }.isEqualTo(expected)
        }
    }

    @Test
    fun `library works correctly for three types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val inputs3 = listOf(1.2f, 2.3f, 3.4f)
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and exactlyOrNull(input2) and anyOf(inputs3[0], inputs3[1], inputs3[2])
        } expect (expected)

        // then
        val testCasesList = testCases.toList()
        expectThat(testCasesList).hasSize(12)
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[0],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            expects = expected,
        )
    }

    @Test
    fun `library works correctly for four types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val inputs3 = listOf(1.2f, 2.3f, 3.4f)
        val inputs4 = Fruit.values()
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and
                    exactlyOrNull(input2) and
                    anyOf(inputs3[0], inputs3[1], inputs3[2]) and
                    anyOf(inputs4) excluding (Fruit.Passionfruit)
        } expect (expected)

        // then
        val testCasesList = testCases.toList()
        expectThat(testCasesList).hasSize(12)
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            expects = expected,
        )
    }

    @Test
    fun `library works correctly for five types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val inputs3 = listOf(1.2f, 2.3f, 3.4f)
        val inputs4 = Fruit.values()
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and
                    exactlyOrNull(input2) and
                    anyOf(inputs3[0], inputs3[1], inputs3[2]) and
                    anyOf(inputs4) excluding (Fruit.Passionfruit) and
                    anyBoolean()
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
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            expects = expected,
        )
    }

    @Test
    fun `library works correctly for six types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val inputs3 = listOf(1.2f, 2.3f, 3.4f)
        val inputs4 = Fruit.values()
        val input6 = "example"
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and
                    exactlyOrNull(input2) and
                    anyOf(inputs3[0], inputs3[1], inputs3[2]) and
                    anyOf(inputs4) excluding (Fruit.Passionfruit) and
                    anyBoolean() and
                    anyOf(input6)
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
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = true,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[0],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[1],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[0],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = input2,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
        expectThat(testCasesList).containsTestCase(
            inputFirst = inputs1[1],
            inputSecond = null,
            inputThird = inputs3[2],
            inputFourth = Fruit.Mango,
            inputFifth = false,
            inputSixth = input6,
            expects = expected,
        )
    }

    @Test
    fun `library works correctly for seven types of inputs`() {
        // given
        val inputs1 = arrayOf(1, 2)
        val input2 = "a"
        val inputs3 = listOf(1.2f, 2.3f, 3.4f)
        val inputs4 = Fruit.values()
        val input6 = "example"
        val input7 = "example2"
        val expected = 124.5f

        // when
        val testCases = combinationsOf {
            anyOf(inputs1) and
                    exactlyOrNull(input2) and
                    anyOf(inputs3[0], inputs3[1], inputs3[2]) and
                    anyOf(inputs4) excluding (Fruit.Passionfruit) and
                    anyBoolean() and
                    anyOf(input6) and
                    exactly(input7)
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
            expects = expected,
        )
    }
}

enum class Fruit {
    Passionfruit, Mango
}