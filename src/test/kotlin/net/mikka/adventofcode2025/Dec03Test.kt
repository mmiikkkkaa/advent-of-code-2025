package net.mikka.adventofcode2025

internal class Dec03Test : AbstractAdventOfCodeTest<Long, Long>() {
    override fun getInput(): String =
        """
  987654321111111
  811111111111119
  234234234234278
  818181911112111

  """

    override fun getInput2(): String = getInput()

    override fun getExpectedValueForPuzzle1(): Long = 357

    override fun getExpectedValueForPuzzle2(): Long = 3121910778619
}
