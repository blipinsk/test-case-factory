package com.barteklipinski.testcasefactory

interface CombinationsBuilder<X, I : Combination> {
    val acceptedValues: List<X>
    val combinations: List<I>
}

// "Next" builder holds previous combinations.
internal interface NextCombinationsBuilder<T : Combination> {
    val previousCombinations: List<T>
}

private fun <X, I : Combination, R : Combination> CombinationsBuilder<X, I>.combineWith(
    previousCombinations: List<R>,
    combinationBuilder: (R, X) -> I,
): List<I> = previousCombinations.flatMap { previousCombination ->
    acceptedValues.map { newValue -> combinationBuilder(previousCombination, newValue) }
}

data class CombinationsBuilder1<A>(
    override val acceptedValues: List<A>,
    override val combinations: List<Combination1<A>> = acceptedValues.map { Combination1(it) },
) : CombinationsBuilder<A, Combination1<A>>

class CombinationsBuilder2<A, B>(
    override val acceptedValues: List<B>,
    override val previousCombinations: List<Combination1<A>>,
) : CombinationsBuilder<B, Combination2<A, B>>, NextCombinationsBuilder<Combination1<A>> {
    override val combinations: List<Combination2<A, B>> =
        combineWith(previousCombinations) { (a), b -> Combination2(a, b) }
}

class CombinationsBuilder3<A, B, C>(
    override val acceptedValues: List<C>,
    override val previousCombinations: List<Combination2<A, B>>,
) : CombinationsBuilder<C, Combination3<A, B, C>>, NextCombinationsBuilder<Combination2<A, B>> {
    override val combinations: List<Combination3<A, B, C>> =
        combineWith(previousCombinations) { (a, b), c -> Combination3(a, b, c) }
}

class CombinationsBuilder4<A, B, C, D>(
    override val acceptedValues: List<D>,
    override val previousCombinations: List<Combination3<A, B, C>>
) : CombinationsBuilder<D, Combination4<A, B, C, D>>,
    NextCombinationsBuilder<Combination3<A, B, C>> {
    override val combinations: List<Combination4<A, B, C, D>> =
        combineWith(previousCombinations) { (a, b, c), d ->
            Combination4(a, b, c, d)
        }
}

class CombinationsBuilder5<A, B, C, D, E>(
    override val acceptedValues: List<E>,
    override val previousCombinations: List<Combination4<A, B, C, D>>
) : CombinationsBuilder<E, Combination5<A, B, C, D, E>>,
    NextCombinationsBuilder<Combination4<A, B, C, D>> {
    override val combinations: List<Combination5<A, B, C, D, E>> =
        combineWith(previousCombinations) { (a, b, c, d), e ->
            Combination5(a, b, c, d, e)
        }
}

class CombinationsBuilder6<A, B, C, D, E, F>(
    override val acceptedValues: List<F>,
    override val previousCombinations: List<Combination5<A, B, C, D, E>>
) : CombinationsBuilder<F, Combination6<A, B, C, D, E, F>>,
    NextCombinationsBuilder<Combination5<A, B, C, D, E>> {
    override val combinations: List<Combination6<A, B, C, D, E, F>> =
        combineWith(previousCombinations) { (a, b, c, d, e), f ->
            Combination6(a, b, c, d, e, f)
        }
}

class CombinationsBuilder7<A, B, C, D, E, F, G>(
    override val acceptedValues: List<G>,
    override val previousCombinations: List<Combination6<A, B, C, D, E, F>>
) : CombinationsBuilder<G, Combination7<A, B, C, D, E, F, G>>,
    NextCombinationsBuilder<Combination6<A, B, C, D, E, F>> {
    override val combinations: List<Combination7<A, B, C, D, E, F, G>> =
        combineWith(previousCombinations) { (a, b, c, d, e, f), g ->
            Combination7(a, b, c, d, e, f, g)
        }
}

class CombinationsBuilder8<A, B, C, D, E, F, G, H>(
    override val acceptedValues: List<H>,
    override val previousCombinations: List<Combination7<A, B, C, D, E, F, G>>
) : CombinationsBuilder<H, Combination8<A, B, C, D, E, F, G, H>>,
    NextCombinationsBuilder<Combination7<A, B, C, D, E, F, G>> {
    override val combinations: List<Combination8<A, B, C, D, E, F, G, H>> =
        combineWith(previousCombinations) { (a, b, c, d, e, f, g), h ->
            Combination8(a, b, c, d, e, f, g, h)
        }
}

class CombinationsBuilder9<A, B, C, D, E, F, G, H, I>(
    override val acceptedValues: List<I>,
    override val previousCombinations: List<Combination8<A, B, C, D, E, F, G, H>>
) : CombinationsBuilder<I, Combination9<A, B, C, D, E, F, G, H, I>>,
    NextCombinationsBuilder<Combination8<A, B, C, D, E, F, G, H>> {
    override val combinations: List<Combination9<A, B, C, D, E, F, G, H, I>> =
        combineWith(previousCombinations) { (a, b, c, d, e, f, g, h), i ->
            Combination9(a, b, c, d, e, f, g, h, i)
        }
}

class CombinationsBuilderN(
    override val acceptedValues: List<Any>,
    override val previousCombinations: List<CombinationN>,
) : CombinationsBuilder<Any, CombinationN>, NextCombinationsBuilder<CombinationN> {
    override val combinations: List<CombinationN> = previousCombinations.flatMap {
        acceptedValues.map { itNext -> CombinationN(it.values + itNext) }
    }
}