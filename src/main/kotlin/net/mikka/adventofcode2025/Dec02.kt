package net.mikka.adventofcode2025

@Suppress("unused")
class Dec02 : PuzzleDay<Long, Long>() {

    override fun getPuzzle1(): Puzzle<Long> {
        return Puzzle01()
    }

    override fun getPuzzle2(): Puzzle<Long> {
        return Puzzle02()
    }

    class Puzzle01 : Puzzle<Long> {
        override fun solve(input: List<String>): Long {
            var invalidIdSum = 0L

            for (range in input.first().split(",")) {
                val (firstId, lastId) = range.split("-")
                for (id in firstId.toLong() .. lastId.toLong()) {

                    if (isInvalidId(id)) {
                        invalidIdSum += id
                    }
                }
            }

            return invalidIdSum
        }

        fun isInvalidId(id: Long): Boolean {
            // invalid means id consists of two equal parts
            val currentId = id.toString()
            if (currentId.length % 2 != 0)
                return false

            val firstPart = currentId.substring(0, currentId.length / 2)
            val secondPart = currentId.substring(currentId.length / 2)

            return firstPart == secondPart
        }
    }

    class Puzzle02 : Puzzle<Long> {
        override fun solve(input: List<String>): Long {
            var invalidIdSum = 0L

            for (range in input.first().split(",")) {
                val (firstId, lastId) = range.split("-")
                for (id in firstId.toLong() .. lastId.toLong()) {

                    if (isInvalidId(id)) {
                        invalidIdSum += id
                    }
                }
            }

            return invalidIdSum
        }

        fun isInvalidId(id: Long): Boolean {
            // invalid means id consists of two or more equal sequences
            val currentId = id.toString()
            val repetitions = mutableListOf<String>()

            for (index in 0 .. currentId.length / 2) {
                repetitions.add(currentId.substring(0, index+1))
            }

            for (repetition in repetitions) {
                val repeatRegex = "^$repetition($repetition)+$".toRegex()
                if (repeatRegex.matches(currentId)) {
                    return true
                }
            }

            return false
        }
    }
}