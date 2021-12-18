package com.barteklipinski.testcasefactory.sample

import com.barteklipinski.testcasefactory.*
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test
import org.junit.runner.RunWith
import strikt.api.expectThat
import strikt.assertions.isEqualTo

// Using JUnitParams library because I like it 🤷.
// test-case-factory can be as easily used with JUnit Parameterized test.
@RunWith(JUnitParamsRunner::class)
class PizzaMakerTest {

    @Test
    @Parameters(method = "pizza maker test cases")
    fun `makeAPizza works correctly`(
        testCase: TestCase<Combination4<PizzaBase, Toppings, Toppings, Int>, PizzaQuality>
    ) {
        // given
        val pizzaMaker = PizzaMaker()
        val pizzaBase = testCase.input.first
        val cheese = testCase.input.second
        val otherToppings = listOf(testCase.input.third)
        val ovenTempCelsius = testCase.input.fourth

        // when
        val pizza = pizzaMaker.makeAPizza(pizzaBase, cheese, otherToppings, ovenTempCelsius)

        // then
        expectThat(pizza).isEqualTo(testCase.expected)
    }

    companion object {
        @JvmStatic
        fun `pizza maker test cases`() = flatArrayOf(
            combinationsOf {
                exactly(PizzaBase) and
                        exactlyOrNull(Toppings.Mozzarella) and
                        anyOf(Toppings.values()) excluding (Toppings.Mozzarella) excluding (Toppings.Pineapple) and
                        exactly(260)
            } expect (PizzaQuality.Fantastic),
            combinationsOf {
                exactly(PizzaBase) and
                        exactlyOrNull(Toppings.Mozzarella) and
                        exactly(Toppings.Pineapple) and
                        exactly(260)
            } expect (PizzaQuality.Debatable),
        )
    }
}
