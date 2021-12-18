package com.barteklipinski.testcasefactory.integration

import com.barteklipinski.testcasefactory.CombinationN
import com.barteklipinski.testcasefactory.TestCase

import strikt.api.Assertion
import strikt.assertions.any
import strikt.assertions.isEqualTo

internal fun <T : Iterable<TC>, TC : TestCase<CombinationN, Result>, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: Any?,
    inputSecond: Any?,
    inputThird: Any?,
    inputFourth: Any?,
    inputFifth: Any?,
    inputSixth: Any?,
    inputSeventh: Any?,
    inputEighth: Any?,
    inputNinth: Any?,
    inputTenth: Any?,
    expects: Result
) {
    any {
        get { input.values[0] }.isEqualTo(inputFirst)
        get { input.values[1] }.isEqualTo(inputSecond)
        get { input.values[2] }.isEqualTo(inputThird)
        get { input.values[3] }.isEqualTo(inputFourth)
        get { input.values[4] }.isEqualTo(inputFifth)
        get { input.values[5] }.isEqualTo(inputSixth)
        get { input.values[6] }.isEqualTo(inputSeventh)
        get { input.values[7] }.isEqualTo(inputEighth)
        get { input.values[8] }.isEqualTo(inputNinth)
        get { input.values[9] }.isEqualTo(inputTenth)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<CombinationN, Result>, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: Any?,
    inputSecond: Any?,
    inputThird: Any?,
    inputFourth: Any?,
    inputFifth: Any?,
    inputSixth: Any?,
    inputSeventh: Any?,
    inputEighth: Any?,
    inputNinth: Any?,
    inputTenth: Any?,
    inputEleventh: Any?,
    expects: Result
) {
    any {
        get { input.values[0] }.isEqualTo(inputFirst)
        get { input.values[1] }.isEqualTo(inputSecond)
        get { input.values[2] }.isEqualTo(inputThird)
        get { input.values[3] }.isEqualTo(inputFourth)
        get { input.values[4] }.isEqualTo(inputFifth)
        get { input.values[5] }.isEqualTo(inputSixth)
        get { input.values[6] }.isEqualTo(inputSeventh)
        get { input.values[7] }.isEqualTo(inputEighth)
        get { input.values[8] }.isEqualTo(inputNinth)
        get { input.values[9] }.isEqualTo(inputTenth)
        get { input.values[10] }.isEqualTo(inputEleventh)
        get { expected }.isEqualTo(expects)
    }
}
