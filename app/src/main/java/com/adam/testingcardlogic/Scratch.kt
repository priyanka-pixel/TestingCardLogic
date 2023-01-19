package com.adam.testingcardlogic

fun scratch(numDigits: String, digits: String, replaceWith: String): String {
    // Convert input strings to integers
    val numDigits = numDigits.toInt()
    val replaceWith = replaceWith.toInt()

    // Convert input string to list of integers
    val digitsList = digits.split(" ").map { it.toInt() }

    // Replace all occurrences of `replaceWith` with 1
    val replacedList = digitsList.map { if (it == replaceWith) 1 else it }

    // Sort the list so that all the 1s are at the start of the list
    val sortedList = replacedList.sortedBy { if (it == 1) 0 else 1 }

    // Convert the list back into a string, with each element separated by a space
    return sortedList.joinToString(" ")
}
fun main() {
    val numDigits = "6"
    val digits = "2 3 6 2 3 2"
    val replaceWith = "2"
    val result = scratch(numDigits, digits, replaceWith)
    println(result)
}