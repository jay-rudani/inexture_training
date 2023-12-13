package oops.functions

// infix notation :
// functions marked with the 'infix' keyword can also be called using the infix notation
// (omitting the . and () for the call)
// requirements :
// they must be member functions or extension functions
// they must have a single param
// the param must not accept vararg and must have no default value
infix fun Int.sumWith(x: Int): Int {
    return this + x
}

fun main() {

    val valueInt: Int = 5
    // similar to valueInt.sumWith(7)
    println(valueInt sumWith 7)
}