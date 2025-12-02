package net.mikka.adventofcode2025

internal class Dec02Test : AbstractAdventOfCodeTest<Long, Long>() {


    override fun getInput(): String = """
11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
"""

    override fun getInput2(): String = getInput()

    override fun getExpectedValueForPuzzle1(): Long = 1227775554L

    override fun getExpectedValueForPuzzle2(): Long = 4174379265L

}