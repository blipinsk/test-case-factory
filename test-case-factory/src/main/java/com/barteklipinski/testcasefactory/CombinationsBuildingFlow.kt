package com.barteklipinski.testcasefactory

class CombinationsBuildingFlow() {

    fun <A> exactly(arg: A): CombinationsBuilder1<A> = CombinationsBuilder1(listOf(arg))

    fun <A> exactlyOrNull(arg: A): CombinationsBuilder1<A?> =
        CombinationsBuilder1(listOf(arg, null))

    @Deprecated(
        message = "For a single argument you should use `exactly` instead",
        replaceWith = ReplaceWith("this.exactly(arg)"),
    )
    fun <A> anyOf(arg: A): CombinationsBuilder1<A> =
        CombinationsBuilder1(listOf(arg))

    @Deprecated(
        message = "For a single argument you should use `exactlyOrNull` instead",
        replaceWith = ReplaceWith("this.exactlyOrNull(arg)"),
    )
    fun <A> anyOfOrNull(arg: A): CombinationsBuilder1<A?> =
        CombinationsBuilder1(listOf(arg, null))

    fun <A> anyOf(arg1: A, arg2: A, vararg args: A): CombinationsBuilder1<A> =
        CombinationsBuilder1(listOf(arg1, arg2, *args))

    fun <A> anyOfOrNull(arg1: A, arg2: A, vararg args: A): CombinationsBuilder1<A?> =
        CombinationsBuilder1(listOf(arg1, arg2, *args, null))

    fun <A> anyOf(args: Array<A>): CombinationsBuilder1<A> = CombinationsBuilder1(args.asList())

    fun <A> anyOfOrNull(args: Array<A>): CombinationsBuilder1<A?> =
        CombinationsBuilder1(args.asList() + null)

    fun <A> anyOf(args: Iterable<A>): CombinationsBuilder1<A> = CombinationsBuilder1(args.toList())

    fun <A> anyOfOrNull(args: Iterable<A>): CombinationsBuilder1<A?> =
        CombinationsBuilder1(args.toList() + null)

    fun anyBoolean(): CombinationsBuilder1<Boolean> = CombinationsBuilder1(listOf(true, false))

    fun anyBooleanOrNull(): CombinationsBuilder1<Boolean?> =
        CombinationsBuilder1(listOf(true, false, null))
}

inline fun <reified C : Combination, CB : CombinationsBuilder<*, C>> combinationsOf(
    execute: CombinationsBuildingFlow.() -> CB
): Array<C> = CombinationsBuildingFlow().execute().combinations.toTypedArray()

infix fun <C : Combination, E> Array<C>.expect(func: () -> E): Array<TestCase<C, E>> =
    expect(func())

infix fun <C : Combination, E> Array<C>.expect(expected: E): Array<TestCase<C, E>> =
    this.map { TestCase(it, expected) }.toTypedArray()
