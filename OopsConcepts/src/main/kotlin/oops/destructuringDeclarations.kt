package oops

data class Result(val marks: Int, val status: String)

fun function(): Result {
    val marks: Int = 95
    val status: String = "PASS"
    return Result(marks, status)
}

fun main() {
    val (marks, status) = function()
    println(marks)
    println(status)
}