package oops

fun swapNums(x: Int, y: Int) {
    var a = x
    var b = y

    a += b
    b = a - b
    a -= b

    println("$a & $b")
}

fun isEvenOrOdd(vararg a: Int) {
    for (i in a) {
        when {
            i % 2 == 0 -> println("$i is even")
            else -> println("$i is odd")
        }
    }
}

fun vowelOrConsonant(char: Char) {
    val char2 = char.lowercaseChar()
    when (char2) {
        'a', 'e', 'i', 'o', 'u' -> println("$char is vowel")
        else -> println("$char is consonant")
    }
}

fun varargDemo(vararg a: Int) {
    for (i in a)
        println(i)
}

fun main() {
    swapNums(73, 63)
    isEvenOrOdd(70, 3, 2, 10, 5, 9)
    vowelOrConsonant('A')

    val array = intArrayOf(3, 4)
    varargDemo(1, 2, *array)
}