package com.barteklipinski.testcasefactory.integration

import com.barteklipinski.testcasefactory.*
import strikt.api.Assertion
import strikt.assertions.any
import strikt.assertions.isEqualTo

internal fun <T : Iterable<TC>, TC : TestCase<Combination1<A>, Result>, A, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<Combination2<A, B>, Result>, A, B, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { input.second }.isEqualTo(inputSecond)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<Combination3<A, B, C>, Result>, A, B, C, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { input.second }.isEqualTo(inputSecond)
        get { input.third }.isEqualTo(inputThird)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<Combination4<A, B, C, D>, Result>, A, B, C, D, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    inputFourth: D,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { input.second }.isEqualTo(inputSecond)
        get { input.third }.isEqualTo(inputThird)
        get { input.fourth }.isEqualTo(inputFourth)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<Combination5<A, B, C, D, E>, Result>, A, B, C, D, E, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    inputFourth: D,
    inputFifth: E,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { input.second }.isEqualTo(inputSecond)
        get { input.third }.isEqualTo(inputThird)
        get { input.fourth }.isEqualTo(inputFourth)
        get { input.fifth }.isEqualTo(inputFifth)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<Combination6<A, B, C, D, E, F>, Result>, A, B, C, D, E, F, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    inputFourth: D,
    inputFifth: E,
    inputSixth: F,
    expects: Result
) {
    any {
        get { input.first }.isEqualTo(inputFirst)
        get { input.second }.isEqualTo(inputSecond)
        get { input.third }.isEqualTo(inputThird)
        get { input.fourth }.isEqualTo(inputFourth)
        get { input.fifth }.isEqualTo(inputFifth)
        get { input.sixth }.isEqualTo(inputSixth)
        get { expected }.isEqualTo(expects)
    }
}

internal fun <T : Iterable<TC>, TC : TestCase<Combination7<A, B, C, D, E, F, G>, Result>, A, B, C, D, E, F, G, Result> Assertion.Builder<T>.containsTestCase(
    inputFirst: A,
    inputSecond: B,
    inputThird: C,
    inputFourth: D,
    inputFifth: E,
    inputSixth: F,
    inputSeventh: G,
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
        get { expected }.isEqualTo(expects)
    }
}
