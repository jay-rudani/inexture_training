package oops.interfaces

// an interface with only one abstract method is called a functional interface or
// single abstract method (SAM) interface
// it can have several non-abstract members but only one abstract member
// to declare SAM interface, use fun keyword
fun interface kRunnalbe {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

fun main() {

    // with SAM conversion, kotlin can convert any lambda expression whose signature matches
    // the signature of the interface's single method into the code, which dynamically
    // instantiates the interface implementation

    // if you don't use SAM conversion
    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    // if you use SAM conversion
    val isOdd = IntPredicate { it % 2 != 0 }

    println("is 3 odd ${isOdd.accept(3)}")
}

typealias DoublePredicate = (d: Double) -> Boolean