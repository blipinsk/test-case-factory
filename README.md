# test-case-factory

A multi-type combinations builder, designed specifically for creating test cases for parameterized testing.
Provides type-safety up to 9 parameters in the combination.

The code might look a bit crazy, but it's just a matter of squeezing everything there is from Kotlin generics.

## Usage
![Usage illustration](/img/usage_illustration.jpg)

```kotlin
val testCases = combinationsOf {
  anyOf(/* accepted values */) excluding(/* excluded value */) and
  exactlyOrNull(/* a single accepted value */)
} expect (/* expected value */) // add expected value for the test case combination
```

## Example

```kotlin
object PizzaBase

enum class Toppings {
  Mozzarella, Pepperoni, Basil,
}

enum class PizzaQuality {
  Fantastic, Debatable
}
```

This:
```kotlin
val testCases = combinationsOf {
  exactly(PizzaBase) and
    exactlyOrNull(Toppings.Mozzarella) and
    anyOf(Toppings.values()) excluding(Toppings.Mozzarella) and
    exactly(260) // oven temperature in centigrade
} expect (PizzaQuality.Fantastic)
```
will produce 4 type-safe combinations (with 4 input fields and 1 expected value).

```kotlin
// testCase[0]
input => [PizzaBase, Toppings.Mozzarella, Toppings.Pepperoni, 260]
expected => PizzaQuality.Fantastic

// testCase[1]
input => [PizzaBase, Toppings.Mozzarella, Toppings.Basil, 260]
expected => PizzaQuality.Fantastic

// testCase[2]
input => [PizzaBase, null, Toppings.Pepperoni, 260]
expected => PizzaQuality.Fantastic

// testCase[3]
input => [PizzaBase, null, Toppings.Pepperoni, 260]
expected => PizzaQuality.Fantastic
```

#### Input

The `input` field contains a generic object which allows you to access grouped values by a set of fields named by the position in the combination builder.

E.g.
```kotlin
testCase[0].input // is of type Combination4<PizzaBase, Toppings?, Toppings, Int>

testCase[0].input.first // is of type `PizzaBase`
testCase[0].input.second // is of type `Toppings?`
testCase[0].input.third // is of type `Toppings`
testCase[0].input.fourth // is of type `Int`
```

If you used more than 4 input values in the `combinationsOf` builder, there would be more fields in `input` (e.g. `fifth`, `sixth`, etc.).

#### Expected

The `expected` field contains an object of type specified by the `expect` function from the test-case building flow.

E.g.
```kotlin
testCase[0] // is of type TestCase<Combination4<PizzaBase, Toppings?, Toppings, Int>, PizzaQuality>
testCase[0].expected // is of type `PizzaQuality`
```

## Mapping

If you don't like the generic `Combination` classes used for `input` fields, you can specify a mapper.

Following the example, you might not like the fact that `input.fourth` of type `Int`, does not contains any information about it being the oven temperature.
```kotlin
data class PizzaRecipe(
  val pizzaBase: Any,
  val cheese: Toppings?,
  val additionalTopping: Toppings,
  val ovenTempCelsius: Int,
)
```

You can use that after creating your `combinations`:
```kotlin
val testCases = combinationsOf {
  exactly(PizzaBase) and
    exactlyOrNull(Toppings.Mozzarella) and
    anyOf(Toppings.values()) excluding(Toppings.Mozzarella) and
    exactly(260) // oven temperature in centigrade
} mappedTo {
  PizzaRecipe(
    pizzaBase = it.first,
    cheese = it.second,
    additionalTopping = it.third,
    ovenTempCelsius = it.fourth,
  )
} expect (PizzaQuality.Fantastic)
```

then the resulting `testCases` will be of type:
```kotlin
TestCase<PizzaRecipe, PizzaQuality>

testCase[0].input // is of type PizzaRecipe
testCase[0].input.cheese // is of type Toppings?
testCase[0].input.additionalTopping // is of type `Toppings`
testCase[0].input.ovenTempCelsius // is of type `Int`
// ...
```

# Including In Your Project

For now this is in alpha (I'm finalising the API).

```groovy
dependencies {
  // WIP
}
```

Developed by
============
 * Bartosz Lipiński

License
=======

    Copyright 2021 Bartosz Lipiński

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
