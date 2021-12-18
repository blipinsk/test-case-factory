package com.barteklipinski.testcasefactory

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import strikt.api.expectThat
import strikt.assertions.*

@RunWith(JUnit4::class)
class CombinationsBuilderExcludingKtTest {

    @Test
    fun `exclude returns list without passed instance`() {
        // given
        val excluded = "three"
        val input = listOf("one", "two", excluded, "four")

        // when
        val result = input.exclude(excluded)

        // then
        expectThat(result).hasSize(input.size - 1)
        expectThat(result).contains(input[0])
        expectThat(result).contains(input[1])
        expectThat(result).doesNotContain(input[2])
        expectThat(result).contains(input[3])
    }

    @Test
    fun `exclude throws IllegalArgument if all values were excluded`() {
        // given
        val excluded = "one"
        val input = listOf(excluded)

        // when
        val throwable = catchThrowable { input.exclude(excluded) }

        // then
        expectThat(throwable).isNotNull()
        expectThat(throwable).isA<IllegalArgumentException>()
        expectThat(throwable!!.message.toString()).containsIgnoringCase("all values were excluded")
    }

    @Test
    fun `exclude throws IllegalArgument if nothing was excluded`() {
        // given
        val excluded = "one"
        val input = listOf("two")

        // when
        val throwable = catchThrowable { input.exclude(excluded) }

        // then
        expectThat(throwable).isNotNull()
        expectThat(throwable).isA<IllegalArgumentException>()
        expectThat(throwable!!.message.toString()).containsIgnoringCase("nothing has been excluded")
    }

    // util
    private fun catchThrowable(action: () -> Any?): Throwable? {
        return try {
            action.invoke()
            null
        } catch (e: Throwable) {
            e
        }
    }
}