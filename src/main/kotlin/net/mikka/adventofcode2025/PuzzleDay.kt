package net.mikka.adventofcode2025

import kotlin.system.measureTimeMillis

abstract class PuzzleDay<T1, T2> {

    private lateinit var input: List<String>

    fun solve() {

        var timeInMs = measureTimeMillis {
            print("${this::class.simpleName}.Puzzle01: " + getPuzzle1().solve(input = testInput()))
        }
        println(" (in $timeInMs ms)")
        timeInMs = measureTimeMillis {
            print("${this::class.simpleName}.Puzzle02: " + getPuzzle2().solve(input = testInput()))
        }
        println(" (in $timeInMs ms)")
        println("###################")
    }

    abstract fun getPuzzle1(): Puzzle<T1>
    abstract fun getPuzzle2(): Puzzle<T2>

    private fun testInput(): List<String> {
        if (this::input.isInitialized) {
            return input
        }

        // TODO: authenticate with gitlab to receive the real values
//        if (!ResourceReader().fileExist(inputFile)) {
//            val content = PuzzleReader().getPuzzleInputExample()
//            ResourceReader().createFile(inputFile, content)
//        }

        input = ResourceReader().readLinesFromResourceFile("/" + this::class.simpleName!!.lowercase() + ".txt")
        return input
    }
}