package com.barteklipinski.testcasefactory

infix fun <A, B> CombinationsBuilder1<A>.and(
    nextInput: CombinationsBuilder1<B>,
): CombinationsBuilder2<A, B> = CombinationsBuilder2(nextInput.acceptedValues, combinations)

infix fun <A, B, C> CombinationsBuilder2<A, B>.and(
    nextInput: CombinationsBuilder1<C>,
): CombinationsBuilder3<A, B, C> = CombinationsBuilder3(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D> CombinationsBuilder3<A, B, C>.and(
    nextInput: CombinationsBuilder1<D>,
): CombinationsBuilder4<A, B, C, D> =
    CombinationsBuilder4(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D, E> CombinationsBuilder4<A, B, C, D>.and(
    nextInput: CombinationsBuilder1<E>,
): CombinationsBuilder5<A, B, C, D, E> =
    CombinationsBuilder5(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D, E, F> CombinationsBuilder5<A, B, C, D, E>.and(
    nextInput: CombinationsBuilder1<F>,
): CombinationsBuilder6<A, B, C, D, E, F> =
    CombinationsBuilder6(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D, E, F, G> CombinationsBuilder6<A, B, C, D, E, F>.and(
    nextInput: CombinationsBuilder1<G>,
): CombinationsBuilder7<A, B, C, D, E, F, G> =
    CombinationsBuilder7(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D, E, F, G, H> CombinationsBuilder7<A, B, C, D, E, F, G>.and(
    nextInput: CombinationsBuilder1<H>,
): CombinationsBuilder8<A, B, C, D, E, F, G, H> =
    CombinationsBuilder8(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D, E, F, G, H, I> CombinationsBuilder8<A, B, C, D, E, F, G, H>.and(
    nextInput: CombinationsBuilder1<I>,
): CombinationsBuilder9<A, B, C, D, E, F, G, H, I> =
    CombinationsBuilder9(nextInput.acceptedValues, combinations)

infix fun <A, B, C, D, E, F, G, H, I, J> CombinationsBuilder9<A, B, C, D, E, F, G, H, I>.and(
    nextInput: CombinationsBuilder1<J>
): CombinationsBuilderN = CombinationsBuilderN(
    acceptedValues = nextInput.acceptedValues.map { it as Any },
    previousCombinations = combinations.map {
        CombinationN(
            listOf(
                it.first,
                it.second,
                it.third,
                it.fourth,
                it.fifth,
                it.sixth,
                it.seventh,
                it.eighth,
                it.ninth,
            )
        )
    },
)

infix fun CombinationsBuilderN.and(nextInput: CombinationsBuilder1<Any>): CombinationsBuilderN =
    CombinationsBuilderN(nextInput.acceptedValues, combinations)

