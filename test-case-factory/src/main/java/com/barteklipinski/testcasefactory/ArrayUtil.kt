package com.barteklipinski.testcasefactory

inline fun <reified C : Combination> flatArrayOf(
    vararg arrays:Array<C>
): Array<C> {
    return listOf(*arrays).map { it.toList() }.flatten().toTypedArray()
}

fun <C : Combination, E> flatArrayOf(
    vararg arrays:Array<TestCase<C,E>>
): Array<TestCase<C,E>> {
    return listOf(*arrays).map { it.toList() }.flatten().toTypedArray()
}