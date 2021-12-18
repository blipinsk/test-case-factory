package com.barteklipinski.testcasefactory

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import strikt.api.Assertion
import strikt.api.expectThat
import strikt.assertions.any
import strikt.assertions.isEqualTo
import strikt.assertions.isNull

@RunWith(JUnit4::class)
class CombinationsBuildingFlowTest {

    @Test
    fun `exactly builds a single combination`() {
        // given
        val input = "string_input"

        // when
        val combinations = combinationsOf { exactly(input) }

        // then
        expectThat(combinations.size).isEqualTo(1)
        expectThat(combinations).containsInput(input)
    }

    @Test
    fun `exactlyOrNull builds a two combinations, one for null`() {
        // given
        val input = "string_input"

        // when
        val combinations = combinationsOf { exactlyOrNull(input) }

        // then
        expectThat(combinations.size).isEqualTo(2)
        expectThat(combinations).containsInput(input)
        expectThat(combinations).containsNullInput()
    }

    @Suppress("deprecation")
    @Test
    fun `anyOf with a single arg builds a single combination`() {
        // given
        val input = "string_input"

        // when
        val combinations = combinationsOf { anyOf(input) }

        // then
        expectThat(combinations.size).isEqualTo(1)
        expectThat(combinations).containsInput(input)
    }

    @Suppress("deprecation")
    @Test
    fun `anyOfOrNull with a single arg builds a two combinations, one for null`() {
        // given
        val input = "string_input"

        // when
        val combinations = combinationsOf { anyOfOrNull(input) }

        // then
        expectThat(combinations.size).isEqualTo(2)
        expectThat(combinations).containsInput(input)
        expectThat(combinations).containsNullInput()
    }

    @Test
    fun `anyOf with two args builds a two combinations`() {
        // given
        val input1 = "first_input"
        val input2 = "second_input"

        // when
        val combinations = combinationsOf { anyOf(input1, input2) }

        // then
        expectThat(combinations.size).isEqualTo(2)
        expectThat(combinations).containsInput(input1)
        expectThat(combinations).containsInput(input2)
    }

    @Test
    fun `anyOfOrNull with two args builds builds a three combinations, one for null`() {
        // given
        val input1 = "first_input"
        val input2 = "second_input"

        // when
        val combinations = combinationsOf { anyOfOrNull(input1, input2) }

        // then
        expectThat(combinations.size).isEqualTo(3)
        expectThat(combinations).containsInput(input1)
        expectThat(combinations).containsInput(input2)
        expectThat(combinations).containsNullInput()
    }

    @Test
    fun `anyOf with array builds a correct number of combinations`() {
        // given
        val input1 = "first_input"
        val input2 = "second_input"
        val input3 = "third_input"
        val inputs = arrayOf(input1, input2, input3)

        // when
        val combinations = combinationsOf { anyOf(inputs) }

        // then
        expectThat(combinations.size).isEqualTo(3)
        expectThat(combinations).containsInput(input1)
        expectThat(combinations).containsInput(input2)
        expectThat(combinations).containsInput(input3)
    }

    @Test
    fun `anyOfOrNull with array builds a correct number of combinations, one for null`() {
        // given
        val input1 = "first_input"
        val input2 = "second_input"
        val input3 = "third_input"
        val inputs = arrayOf(input1, input2, input3)

        // when
        val combinations = combinationsOf { anyOfOrNull(inputs) }

        // then
        expectThat(combinations.size).isEqualTo(4)
        expectThat(combinations).containsInput(input1)
        expectThat(combinations).containsInput(input2)
        expectThat(combinations).containsInput(input3)
        expectThat(combinations).containsNullInput()
    }

    @Test
    fun `anyOf with iterable builds a correct number of combinations`() {
        // given
        val input1 = "first_input"
        val input2 = "second_input"
        val input3 = "third_input"
        val inputs = listOf(input1, input2, input3)

        // when
        val combinations = combinationsOf { anyOf(inputs) }

        // then
        expectThat(combinations.size).isEqualTo(3)
        expectThat(combinations).containsInput(input1)
        expectThat(combinations).containsInput(input2)
        expectThat(combinations).containsInput(input3)
    }

    @Test
    fun `anyOfOrNull with iterable builds a correct number of combinations, one for null`() {
        // given
        val input1 = "first_input"
        val input2 = "second_input"
        val input3 = "third_input"
        val inputs = listOf(input1, input2, input3)

        // when
        val combinations = combinationsOf { anyOfOrNull(inputs) }

        // then
        expectThat(combinations.size).isEqualTo(4)
        expectThat(combinations).containsInput(input1)
        expectThat(combinations).containsInput(input2)
        expectThat(combinations).containsInput(input3)
        expectThat(combinations).containsNullInput()
    }

    @Test
    fun `anyBoolean builds a two combinations`() {
        // given -> no additional setup

        // when
        val combinations = combinationsOf { anyBoolean() }

        // then
        expectThat(combinations.size).isEqualTo(2)
        expectThat(combinations).containsInput(true)
        expectThat(combinations).containsInput(false)
    }

    @Test
    fun `anyBooleanOrNull builds a three combinations, one for null`() {
        // given -> no additional setup

        // when
        val combinations = combinationsOf { anyBooleanOrNull() }

        // then
        expectThat(combinations.size).isEqualTo(3)
        expectThat(combinations).containsInput(true)
        expectThat(combinations).containsInput(false)
        expectThat(combinations).containsNullInput()
    }

    private fun <T : Combination1<A>, A> Assertion.Builder<Array<T>>.containsInput(expected: A) {
        get { toList() }.any { get { first }.isEqualTo(expected) }
    }

    // bonus: this works only for a Combination1 with a nullable arg
    private fun <T : Combination1<A?>, A> Assertion.Builder<Array<T>>.containsNullInput() {
        get { toList() }.any { get { first }.isNull() }
    }
}