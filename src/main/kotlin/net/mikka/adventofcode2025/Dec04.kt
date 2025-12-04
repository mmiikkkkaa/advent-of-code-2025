package net.mikka.adventofcode2025

@Suppress("unused")
class Dec04 : PuzzleDay<Long, Long>() {

    companion object {
        private fun getAdjacentCharacters(
            row: Int,
            col: Int,
            input: List<String>,
            line: String
        ): List<Char> {
            val adjacent = mutableListOf<Char>()

            // former row
            if (row > 0) {
                if (col > 0) {
                    adjacent.add(input[row - 1][col - 1])
                }
                adjacent.add(input[row - 1][col])
                if (col < line.length - 1) {
                    adjacent.add(input[row - 1][col + 1])
                }
            }
            // current row
            if (col > 0) {
                adjacent.add(input[row][col - 1])
            }
            adjacent.add(input[row][col])
            if (col < line.length - 1) {
                adjacent.add(input[row][col + 1])
            }

            // next row
            if (row < input.size - 1) {
                if (col > 0) {
                    adjacent.add(input[row + 1][col - 1])
                }
                adjacent.add(input[row + 1][col])
                if (col < line.length - 1) {
                    adjacent.add(input[row + 1][col + 1])
                }
            }
            return adjacent
        }
    }

    override fun getPuzzle1(): Puzzle<Long> = Puzzle01()

    override fun getPuzzle2(): Puzzle<Long> = Puzzle02()

    class Puzzle01 : Puzzle<Long> {
        override fun solve(input: List<String>): Long {
            var accessiblePaperRollCount = 0L
            for ((row, line) in input.withIndex()) {
                for ((col, c) in line.withIndex()) {
                    if (c == '.') {
                        continue
                    }

                    val adjacentCharacters = getAdjacentCharacters(row, col, input, line)
                    if (adjacentCharacters.count { c -> c == '@' } <= 4) {
                        accessiblePaperRollCount++
                    }
                }
            }
            return accessiblePaperRollCount
        }
    }

    class Puzzle02 : Puzzle<Long> {
        override fun solve(input: List<String>): Long {

            val modifiableInput = input.toMutableList()

            var accessiblePaperRollCountTotal = 0L

            do {
                val accessiblePaperRolls = mutableListOf<Pair<Int, Int>>()

                for ((row, line) in modifiableInput.withIndex()) {
                    for ((col, c) in line.withIndex()) {
                        if (c == '.') {
                            continue
                        }

                        val adjacentCharacters = getAdjacentCharacters(row, col, modifiableInput, line)
                        if (adjacentCharacters.count { c -> c == '@' } <= 4) {
                            accessiblePaperRolls.add(Pair(row, col))
                        }
                    }
                }
                accessiblePaperRollCountTotal += accessiblePaperRolls.size

                for (coordinate in accessiblePaperRolls) {
                    modifiableInput[coordinate.first] =
                        modifiableInput[coordinate.first].replaceRange(coordinate.second, coordinate.second + 1, ".")
                }

            } while (accessiblePaperRolls.isNotEmpty())

            return accessiblePaperRollCountTotal
        }
    }
}
