package oops.classes

// 'lateinit' is used to declare those variables that are guaranteed to be initialized in the future
// properties of primitive data types (Int, Double) as well as nullable properties cannot be
// declared using 'lateinit'

class LateInitDemo {

    lateinit var myVariable: String

    fun initializeName() {
        println("is myVariable initialized? : ${this::myVariable.isInitialized}")
        myVariable = "Hello World!"
        println("is myVariable initialized? : ${this::myVariable.isInitialized}")
    }
}

fun main() {
    LateInitDemo().initializeName()
}