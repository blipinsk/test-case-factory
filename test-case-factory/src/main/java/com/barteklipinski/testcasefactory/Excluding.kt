package com.barteklipinski.testcasefactory

internal fun <E> List<E>.exclude(e: E): List<E> {
    val newInputs = this.filterNot { it == e }
    require(newInputs.isNotEmpty()) { "All values were excluded from: $this" }
    require(this.size != newInputs.size) { "Nothing has been excluded from values: $this" }
    return newInputs
}

infix fun <A> CombinationsBuilder1<A>.excluding(a: A): CombinationsBuilder1<A> {
    return CombinationsBuilder1(acceptedValues.exclude(a))
}

infix fun <A, B> CombinationsBuilder2<A, B>.excluding(b: B): CombinationsBuilder2<A, B> {
    return CombinationsBuilder2(acceptedValues.exclude(b), previousCombinations)
}

infix fun <A, B, C> CombinationsBuilder3<A, B, C>.excluding(c: C): CombinationsBuilder3<A, B, C> {
    return CombinationsBuilder3(acceptedValues.exclude(c), previousCombinations)
}

infix fun <A, B, C, D> CombinationsBuilder4<A, B, C, D>.excluding(d: D): CombinationsBuilder4<A, B, C, D> {
    return CombinationsBuilder4(acceptedValues.exclude(d), previousCombinations)
}

infix fun <A, B, C, D, E> CombinationsBuilder5<A, B, C, D, E>.excluding(e: E): CombinationsBuilder5<A, B, C, D, E> {
    return CombinationsBuilder5(acceptedValues.exclude(e), previousCombinations)
}

infix fun <A, B, C, D, E, F> CombinationsBuilder6<A, B, C, D, E, F>.excluding(f: F): CombinationsBuilder6<A, B, C, D, E, F> {
    return CombinationsBuilder6(acceptedValues.exclude(f), previousCombinations)
}

infix fun <A, B, C, D, E, F, G> CombinationsBuilder7<A, B, C, D, E, F, G>.excluding(g: G): CombinationsBuilder7<A, B, C, D, E, F, G> {
    return CombinationsBuilder7(acceptedValues.exclude(g), previousCombinations)
}

infix fun <A, B, C, D, E, F, G, H> CombinationsBuilder8<A, B, C, D, E, F, G, H>.excluding(h: H): CombinationsBuilder8<A, B, C, D, E, F, G, H> {
    return CombinationsBuilder8(acceptedValues.exclude(h), previousCombinations)
}

infix fun <A, B, C, D, E, F, G, H, I> CombinationsBuilder9<A, B, C, D, E, F, G, H, I>.excluding(i: I): CombinationsBuilder9<A, B, C, D, E, F, G, H, I> {
    return CombinationsBuilder9(acceptedValues.exclude(i), previousCombinations)
}

infix fun CombinationsBuilderN.excluding(x: Any): CombinationsBuilderN {
    return CombinationsBuilderN(acceptedValues.exclude(x), previousCombinations)
}

