package oops.nullSafety

// possible causes of an NullPointerException in kotlin are :
// 1. an explicit call to throw NullPointerException()
// 2. usage of the !! operator
// 3. data inconsistency with regard to its initialization

fun main() {
    val a: String = "abc" // regular initialization means non-nullable by default
    // a = null // compilation error

    var b: String? = "abc"// can be set to null
    b = null //OK
    println(b)

    // if you call a method or access property 'a', it's guaranteed not to cause an NPE
    println(a.length)
    // but if you want to do same with 'b', that wouldn't be safe
    // println(b.length) // error : variable 'b' can be null

    // ways to access b.length, first check whether 'b' is not null
    var lengthOfB = if (b != null) b.length else -1
    // second option for accessing a property on a nullable variable is using the
    // safe call operator '?.'
    println(b?.length)
    // this will print length of 'b' if it's not null, and null otherwise
}