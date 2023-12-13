package oops.extensions

// you can write new functions for a class or an interface from a third-party library
// that you can't modify, such functions can be called in the usual way, as if they were
// methods of the original class
// this mechanism is called 'extension function'
// there are also 'extension properties' that let you define new properties for existing classes

// to declare an extension function, prefix its name with a receiver type, which refers
// to the type being extended

// this will add swap() function to MutableList<Int>
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'list'
    println(list)

    // extensions are resolved statically
    // they do not actually modify the classes (means you are not inserting new members to it)
    // only making new functions callable with dot-notation on variables of this type
    // extension functions are dispatched statically, so which extension function is called is
    // already known at compile time based on receiver type
    open class Shape
    class Rectangle : Shape()

    fun Shape.getName() = "Shape"
    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) = println(s.getName())

    printClassName(Rectangle())

    // if a class has a member function, and an extension function is defined which has
    // the same receiver type, the same name, and is applicable to given arguments,
    // the member always wins
    class Example {
        fun printFunctionType() {
            println("Class method")
        }
    }

    fun Example.printFunctionType() {
        println("Extension function")
    }

    Example().printFunctionType()

    // it's perfectly OK for extension functions to overload member functions that have
    // the same name but different signature
    fun Example.printFunctionType(i: Int) {
        println("Extension function #$i")
    }
    Example().printFunctionType(1)

    // nullable receiver :
    // extensions can be defined with nullable receiver type
    // these extensions can be called on an object variable even if its value is null
    // if receiver is null then 'this' is also null
    fun Any?.toString(): String {
        if (this == null) return "null"
        return toString()
    }

    MyClass.printCompanion()
}

// companion object extensions :
// if a class has a companion object defined, you can also define extension functions and
// properties for the companion object
class MyClass {
    companion object {}
}

fun MyClass.Companion.printCompanion() {
    println("companion")
}