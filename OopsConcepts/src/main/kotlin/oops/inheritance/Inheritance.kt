package oops.inheritance

// all classes in Kotlin have a common superclass 'Any', which is default superclass for a class
// with no supertypes declared
// ex : class Example // implicitly inherits from Any
// 'Any' has three methods : equals(), hasCode() and toString()
// by default, kotlin classes are final - they cannot be inherited
// to make a class inheritable, mark it with 'open' keyword
// ex : open class Base // class is open for inheritance

fun main() {
    val onePlusMobile = OnePlus("SmartPhone")
    onePlusMobile.display()
    println(onePlusMobile.toString())
}

open class Mobile(val type: String) {
    open val name: String = ""
    open val size: Int = 5
    fun makeCall() = println("Calling from mobile")
    fun powerOff() = println("Shutting down")
    open fun display() = println("Simple mobile display")
}

// if there is no 'open' modifier on function, like makeCall(), declaring a
// method with same signature in a subclass is not allowed, either with override or
// without it
// the 'open' modifier has no affect when added to members of a final class - a class
// without an 'open' modifier
class OnePlus(typeParam: String) : Mobile(typeParam) {
    override val name: String = "OnePlus"
    override val size: Int = 6
    override fun display() {
        super.display()
        println("OnePlus Display")
    }

    override fun toString(): String {
        return "OnePlus(name='$name', size=$size)"
    }
}

// a member marked 'override' is itself open, so it may be overridden in subclasses
// if you want to prohibit re-overriding, use final :
/*
    open class Rectangle() : Shape() {
        final override fun draw() {
            /*...*/
        }
    }
*/