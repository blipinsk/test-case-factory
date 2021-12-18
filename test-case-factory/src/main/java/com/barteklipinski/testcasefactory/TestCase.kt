package com.barteklipinski.testcasefactory

data class TestCase<I, EXPECTED>(
    val input: I,
    val expected: EXPECTED,
){
    override fun toString(): String {
        return "expecting=[$expected], for input=$input"
    }
}