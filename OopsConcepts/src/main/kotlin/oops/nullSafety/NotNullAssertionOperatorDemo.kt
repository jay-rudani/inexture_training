package oops.nullSafety

// this option is for if you want NPE
// not-null assertion operator (!!) converts any value to a non-nullable type
// and throws an exception if the value is null
fun main() {

    val someValue: String? = null
    println(someValue!!.length)
}