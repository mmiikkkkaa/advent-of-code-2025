package net.mikka.adventofcode2025.templates

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.plusParameter
import net.mikka.adventofcode2025.Puzzle
import net.mikka.adventofcode2025.PuzzleDay
import net.mikka.adventofcode2025.ResourceReader
import java.nio.file.Paths
import java.time.LocalDateTime


fun main() {
    generatePuzzleFile()
    generatePuzzleTestFile()
    generatePuzzleInputFile()
}

private fun generatePuzzleFile() {
    val today = LocalDateTime.now()
    val packageName = "net.mikka.adventofcode" + today.year
    val className = "Dec" + String.format("%02d", today.dayOfMonth)

    val file = FileSpec.builder(packageName, className)
        .addType(
            TypeSpec.classBuilder(className)
                .addModifiers()
                .superclass(PuzzleDay::class.parameterizedBy(Int::class, Int::class))
                .addFunction(
                    FunSpec.builder("getPuzzle1")
                        .returns(Puzzle::class.parameterizedBy(Int::class))
                        .addModifiers(KModifier.OVERRIDE)
                        .addCode("return Puzzle01()")
                        .build()
                )
                .addFunction(
                    FunSpec.builder("getPuzzle2")
                        .returns(Puzzle::class.parameterizedBy(Int::class))
                        .addModifiers(KModifier.OVERRIDE)
                        .addCode("return Puzzle02()")
                        .build()
                )
                .addType(
                    TypeSpec.classBuilder("Puzzle01")
                        .addSuperinterface(Puzzle::class.parameterizedBy(Int::class))
                        .addFunction(
                            FunSpec.builder("solve")
                                .returns(Int::class)
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("input", List::class.parameterizedBy(String::class))
                                .addStatement("TODO()")
                                .build()
                        )
                        .build()
                )
                .addType(
                    TypeSpec.classBuilder("Puzzle02")
                        .addSuperinterface(Puzzle::class.parameterizedBy(Int::class))
                        .addFunction(
                            FunSpec.builder("solve")
                                .returns(Int::class)
                                .addModifiers(KModifier.OVERRIDE)
                                .addParameter("input", List::class.parameterizedBy(String::class))
                                .addStatement("TODO()")
                                .build()
                        )
                        .build()
                )
                .build()
        )
        .build()

    val directory = Paths.get("", today.year.toString(), "src", "main", "kotlin").toAbsolutePath()
    file.writeTo(directory = directory)
}

private fun generatePuzzleTestFile() {
    val puzzleReader = PuzzleReader()

    val today = LocalDateTime.now()
    val packageName = "net.mikka.adventofcode" + today.year
    val className = "Dec" + String.format("%02d", today.dayOfMonth) + "Test"
    val file = FileSpec.builder(packageName, className)
        .addType(
            TypeSpec.classBuilder(className)
                .addModifiers(KModifier.INTERNAL)
                .superclass(
                    ClassName(packageName, "AbstractAdventOfCodeTest")
                        .plusParameter(ClassName("kotlin", "Int"))
                        .plusParameter(ClassName("kotlin", "Int"))
                )
                .addFunction(
                    FunSpec.builder("getInput")
                        .returns(String::class)
                        .addModifiers(KModifier.OVERRIDE)
                        .addCode(
                            """
|return 
|""${'"'}
|${puzzleReader.getPuzzleInputExample()}
|""${'"'}
""".trimMargin()
                        )
                        .build()
                )
                .addFunction(
                    FunSpec.builder("getInput2")
                        .returns(String::class)
                        .addModifiers(KModifier.OVERRIDE)
                        .addCode(
                            "return getInput()"
                        )
                        .build()
                )
                .addFunction(
                    FunSpec.builder("getExpectedValueForPuzzle1")
                        .returns(Int::class)
                        .addModifiers(KModifier.OVERRIDE)
                        .addCode("return " + puzzleReader.getPuzzleExampleResult())
                        .build()
                )
                .addFunction(
                    FunSpec.builder("getExpectedValueForPuzzle2")
                        .returns(Int::class)
                        .addModifiers(KModifier.OVERRIDE)
                        .addCode("return " + puzzleReader.getPuzzleExampleResult())
                        .build()
                )
                .build()
        )
//        .addCode(
//            """
//            internal class $className : AbstractAdventOfCodeTest<Int, Int>() {
//
//              override fun getInput(): String = ""${'"'}
//                 ${puzzleReader.getPuzzleInputExample()}
//              ""${'"'}
//
//              override fun getInput2(): String = getInput()
//
//              override fun getExpectedValueForPuzzle1(): Int = ${puzzleReader.getPuzzleExampleResult()}
//
//              override fun getExpectedValueForPuzzle2(): Int = ${puzzleReader.getPuzzleExampleResult()}
//            }
//            """.trimIndent()
//        )
        .build()

    val directory = Paths.get("", today.year.toString(), "src", "test", "kotlin").toAbsolutePath()
    file.writeTo(directory = directory)
}

private fun generatePuzzleInputFile() {
    val today = LocalDateTime.now()
    val fileName = "dec" + String.format("%02d", today.dayOfMonth) + ".txt"
    ResourceReader().createFile("/$fileName", "")
}