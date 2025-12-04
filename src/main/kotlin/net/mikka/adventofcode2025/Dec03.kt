package net.mikka.adventofcode2025

class Dec03 : PuzzleDay<Long, Long>() {

    companion object {
        private fun getIndexOfHighestNumber(line: String, startIndex: Int, endIndex: Int): Int {
            var currentMax = 0
            var indexOfMax = 0
            for (i in startIndex..endIndex) {
                val current = line[i].toString().toInt()
                if (current > currentMax) {
                    currentMax = current
                    indexOfMax = i
                    if (currentMax == 9) {
                        break;
                    }
                }
            }

            return indexOfMax
        }

        private fun getJoltageOfLine(line: String, numberOfBatteriesToUse: Int): Long {
            val indexes = mutableListOf<Int>()
            var startIndex = 0
            var endIndex = line.length - numberOfBatteriesToUse

            for (i in 1..numberOfBatteriesToUse) {
                val index = getIndexOfHighestNumber(line, startIndex, endIndex++)
                indexes.add(index)
                startIndex = index + 1
            }

            val stringBuilder = StringBuilder()
            indexes.forEach { stringBuilder.append(line[it]) }

            return stringBuilder.toString().toLong()
        }
    }

    override fun getPuzzle1(): Puzzle<Long> = Puzzle01()

    override fun getPuzzle2(): Puzzle<Long> = Puzzle02()

    class Puzzle01 : Puzzle<Long> {
        override fun solve(input: List<String>): Long {
            val numberOfBatteriesToUse = 2
            var totalOutputJoltage = 0L

            for (line in input) {
                val joltage = getJoltageOfLine(line, numberOfBatteriesToUse)
                totalOutputJoltage += joltage
            }

            return totalOutputJoltage
        }

    }

    class Puzzle02 : Puzzle<Long> {
        override fun solve(input: List<String>): Long {
            val numberOfBatteriesToUse = 12
            var totalOutputJoltage = 0L

            for (line in input) {
                val joltage = getJoltageOfLine(line, numberOfBatteriesToUse)
                totalOutputJoltage += joltage
            }

            return totalOutputJoltage
        }
    }


}
