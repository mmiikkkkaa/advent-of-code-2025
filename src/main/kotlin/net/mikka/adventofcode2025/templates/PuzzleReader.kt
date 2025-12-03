package net.mikka.adventofcode2025.templates

import java.net.URL
import java.time.LocalDate


class PuzzleReader {

    private val puzzlePageContent: String

    constructor() {
        puzzlePageContent = readPuzzlePageContent()
    }

    companion object {
        const val PUZZLE_URL = "https://adventofcode.com/%s/day/%s"
        const val PUZZLE_INPUT_URL = "$PUZZLE_URL/input"
        val PUZZLE_INPUT_REGEX = """<pre><code>(?<input>.+?)</code></pre>""".toRegex(RegexOption.DOT_MATCHES_ALL)
        val PUZZLE_RESULT_REGEX = """<code><em>(?<result>.+?)</em></code>""".toRegex(RegexOption.DOT_MATCHES_ALL)
    }

    fun readPuzzlePageContent(): String {
        val today = LocalDate.now()
        val puzzleUrl = PUZZLE_URL.format(today.year, today.dayOfMonth)
        println("puzzleUrl: $puzzleUrl")
        return URL(puzzleUrl).readText()
    }

    fun getPuzzleInputExample(): String {
        return PUZZLE_INPUT_REGEX.find(puzzlePageContent)!!.groups[1]!!.value
    }


    fun getPuzzleExampleResult(): String {
        return PUZZLE_RESULT_REGEX.findAll(puzzlePageContent).last().groups[1]!!.value
    }
}