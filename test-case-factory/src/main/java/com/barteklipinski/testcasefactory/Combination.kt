package com.barteklipinski.testcasefactory

interface Combination

data class Combination1<A>(
    val first: A,
) : Combination {
    override fun toString(): String = "[$first]"
}

data class Combination2<A, B>(
    val first: A,
    val second: B,
) : Combination {
    override fun toString(): String = "[$first, $second]"
}

data class Combination3<A, B, C>(
    val first: A,
    val second: B,
    val third: C,
) : Combination {
    override fun toString(): String = "[$first, $second, $third]"
}

data class Combination4<A, B, C, D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
) : Combination {
    override fun toString(): String = "[$first, $second, $third, $fourth]"
}

data class Combination5<A, B, C, D, E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
) : Combination {
    override fun toString(): String = "[$first, $second, $third, $fourth, $fifth]"
}

data class Combination6<A, B, C, D, E, F>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
) : Combination {
    override fun toString(): String = "[$first, $second, $third, $fourth, $fifth, $sixth]"
}

data class Combination7<A, B, C, D, E, F, G>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G,
) : Combination {
    override fun toString(): String = "[$first, $second, $third, $fourth, $fifth, $sixth, $seventh]"
}

data class Combination8<A, B, C, D, E, F, G, H>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G,
    val eighth: H,
) : Combination {
    override fun toString(): String =
        "[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth]"
}

data class Combination9<A, B, C, D, E, F, G, H, I>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G,
    val eighth: H,
    val ninth: I,
) : Combination {
    override fun toString(): String =
        "[$first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth, $ninth]"
}

data class CombinationN(
    val values: List<Any?>
) : Combination {
    override fun toString(): String = values.joinToString(prefix = "[", postfix = "]")
}