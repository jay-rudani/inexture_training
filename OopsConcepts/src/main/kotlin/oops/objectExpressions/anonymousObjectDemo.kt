package oops.objectExpressions

// object expressions start with 'object' keyword

fun main() {

    // if you just need an object that doesn't have any nontrivial supertypes,
    // write its members in {} after 'object' :
    val helloWorld = object {
        val hello = "Hello"
        val world = "World"

        override fun toString(): String = "$hello $world"
    }

    println(helloWorld)

    // inheriting anonymous objects from supertypes
    // To create an object of an anonymous class that inherits from some type (or types),
    // specify this type after object and a colon (:)
    // Then implement or override the members of this class as if you were inheriting from it
    val ab: A = object : A(1), B {
        override val y: Int
            get() = 15
    }
    println(ab.y)

}

open class A(x: Int) {
    open val y: Int = x
}

interface B {}

// using anonymous objects as return and value types
// when an anonymous object is used as a type of local or private but not inline declaration (func/prop),
// all its members are accessible via this function or property :
class C {
    private fun getObject() = object {
        val x: String = "x"
    }

    fun printX() {
        println(getObject().x)
    }
}