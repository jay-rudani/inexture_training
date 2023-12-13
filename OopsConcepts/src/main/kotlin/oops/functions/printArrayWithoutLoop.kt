package oops.functions

var i: Int = 0

fun <T> printArray(array: Array<T>) {
    println(array[i])
    i++
    if (i == array.size)
        return
    printArray(array)
}

fun main() {

    val numberArray = arrayOf(1, 2, 3, 4, 5)
    printArray(numberArray)
}