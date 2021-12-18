package com.barteklipinski.testcasefactory.integration

import com.barteklipinski.testcasefactory.Combination8
import com.barteklipinski.testcasefactory.TestCase
import strikt.api.Assertion
import strikt.assertions.any
import strikt.assertions.isEqualTo

internal fun <T : Iterable<TC>, TC : TestCase<Combination8<A, B, C, D, E, F, G, H>, Result>, A, B, C, D, E, F, G, H, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    inputFourth: D,
    inputFifth: E,
    inputSixth: F,
    inputSeventh: G,
    inputEighth: H,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { input.second }.isEqualTo(inputSecond)
        get { input.third }.isEqualTo(inputThird)
        get { input.fourth }.isEqualTo(inputFourth)
        get { input.fifth }.isEqualTo(inputFifth)
        get { input.sixth }.isEqualTo(inputSixth)
        get { input.seventh }.isEqualTo(inputSeventh)
        get { input.eighth }.isEqualTo(inputEighth)
        get { expected }.isEqualTo(expects)
    }
}