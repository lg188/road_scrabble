package net.lg188.roadScrabble

class Rules {
    var scoreMultiplier: IntArray


    // TODO: This constructor is a temporary measure. This class should be used as a template for rulesets, with modular score multipliers and, and word/tile modifiers.
    constructor(presetName: String){
        when(presetName.toLowerCase()){
            "belgium" -> {
                scoreMultiplier = intArrayOf(1, 3, 5, 2, 1, 4, 3, 4, 1, 4, 3, 3, 3, 1, 1, 3, 10, 2, 2, 2, 4, 4, 5, 8, 8, 4)

            }

            else -> {
                scoreMultiplier = intArrayOf(1, 3, 5, 2, 1, 4, 3, 4, 1, 4, 3, 3, 3, 1, 1, 3, 10, 2, 2, 2, 4, 4, 5, 8, 8, 4)
            }
        }
    }
}