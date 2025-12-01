package net.mikka.adventofcode2025

internal class Dec01Test : AbstractAdventOfCodeTest<Int, Int>() {


    override fun getInput(): String = """
L68
L30
R48
L5
R60
L55
L1
L99
R14
L82
"""

    override fun getInput2(): String = """
L68
L30
R48
L5
R60
L55
L1
L99
R14
L82
"""

    override fun getExpectedValueForPuzzle1(): Int = 3

    override fun getExpectedValueForPuzzle2(): Int = 6

}