package net.mikka.adventofcode2025

import kotlin.Long
import kotlin.String

internal class Dec04Test : AbstractAdventOfCodeTest<Long, Long>() {
  override fun getInput(): String = 
  """
  ..@@.@@@@.
  @@@.@.@.@@
  @@@@@.@.@@
  @.@@@@..@.
  @@.@@@@.@@
  .@@@@@@@.@
  .@.@.@.@@@
  @.@@@.@@@@
  .@@@@@@@@.
  @.@.@@@.@.

  """

  override fun getInput2(): String = getInput()

  override fun getExpectedValueForPuzzle1(): Long = 13

  override fun getExpectedValueForPuzzle2(): Long = 43
}
