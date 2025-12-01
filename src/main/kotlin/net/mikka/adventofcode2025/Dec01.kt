package net.mikka.adventofcode2025

class Dec01 : PuzzleDay<Int, Int>() {

    override fun getPuzzle1(): Puzzle<Int> {
        return Puzzle01()
    }

    override fun getPuzzle2(): Puzzle<Int> {
        return Puzzle02()
    }

    class Puzzle01 : Puzzle<Int> {
        override fun solve(input: List<String>): Int {
            val start = 50

            var current = start
            var zeroCounter = 0

            for (line in input) {
                val change = line.substring(1).toInt()
                if (line.startsWith("R")) {
                    current += change
                } else {
                    current -= change
                }
                current = current % 100

                if (current == 0) {
                    zeroCounter++
                }
            }
            return zeroCounter
        }
    }

    class Puzzle02 : Puzzle<Int> {
        override fun solve(input: List<String>): Int {
            val start = 50

            var current = start
            var zeroCounter = 0

            for (line in input) {
                val change = line.substring(1).toInt()

                for (i in 0 until change) {
                    if (line.startsWith("R")) {
                        current++
                    } else {
                        current--
                    }
                    current = (current + 100) % 100
                    if (current == 0) {
                        zeroCounter++
                    }
                }
            }
            return zeroCounter
        }
    }
}