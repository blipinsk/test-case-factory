package com.barteklipinski.testcasefactory.sample

class PizzaMaker {

    fun makeAPizza(
        pizzaBase: PizzaBase?,
        cheese: Toppings?,
        otherToppings: List<Toppings>,
        ovenTempCelsius: Int,
    ): PizzaQuality {
        if (ovenTempCelsius < 250) {
            return PizzaQuality.Questionable
        }
        if (pizzaBase != null) {
            if (otherToppings.contains(Toppings.Pineapple)) {
                return PizzaQuality.Debatable
            } else if (cheese != null || otherToppings.isNotEmpty()) {
                return PizzaQuality.Fantastic
            }
        }
        return PizzaQuality.Questionable
    }
}

object PizzaBase

enum class Toppings {
    Mozzarella, Pepperoni, Basil, Pineapple, Onion, GrilledVegetables
}

enum class PizzaQuality {
    Fantastic, Questionable, Debatable
}
