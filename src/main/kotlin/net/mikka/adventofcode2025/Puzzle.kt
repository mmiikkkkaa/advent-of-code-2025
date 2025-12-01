package net.mikka.adventofcode2025

interface Puzzle<T> {
    fun solve(input:List<String>): T
}