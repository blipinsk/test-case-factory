package com.barteklipinski.testcasefactory

infix fun <C : Combination, R> Array<C>.mappedTo(func: (C) -> R) = MappedCombinations(map(func))

data class MappedCombinations<R>(val raw: List<R>)

infix fun <R, E> MappedCombinations<R>.expect(func: () -> E): Array<TestCase<R, E>> =
    expect(func())

infix fun <R, E> MappedCombinations<R>.expect(expected: E): Array<TestCase<R, E>> =
    this.raw.map { TestCase(it, expected) }.toTypedArray()