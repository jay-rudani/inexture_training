package oops.functions

//fun sum(leftOpd: Double, rightOpd: Double): Double {
//    return leftOpd + rightOpd
//}

fun calculator(leftOpd: Double, rightOpd: Double, fn: (Double, Double) -> Double) {
    val result = fn(leftOpd, rightOpd)
    println(result)
}

fun main() {

    calculator(13.0, 13.0) { x, y -> x + y }
}