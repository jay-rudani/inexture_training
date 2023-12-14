package oops.nullSafety

fun main() {

    // when you have a nullable reference, 'b', you can say "if 'b' is not null, use it, otherwise
    // use some non-null value
    val someValue: String? = null
    println(someValue?.length ?: -1)

    // if the expression of the left of ?: not null, elvis operator returns it
    // otherwise it returns the expression to the right
    // NOTE : expression on the right side is only evaluated if left-side is null
}