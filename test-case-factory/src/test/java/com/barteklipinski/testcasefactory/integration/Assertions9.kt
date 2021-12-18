package com.barteklipinski.testcasefactory.integration

import com.barteklipinski.testcasefactory.Combination9
import com.barteklipinski.testcasefactory.TestCase
import strikt.api.Assertion
import strikt.assertions.any
import strikt.assertions.isEqualTo

internal fun <T : Iterable<TC>, TC : TestCase<Combination9<A, B, C, D, E, F, G, H, I>, Result>, A, B, C, D, E, F, G, H, I, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    inputFourth: D,
    inputFifth: E,
    inputSixth: F,
    inputSeventh: G,
    inputEighth: H,
    inputNinth: I,
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
        get { input.ninth }.isEqualTo(inputNinth)
        get { expected }.isEqualTo(expects)
    }
}
