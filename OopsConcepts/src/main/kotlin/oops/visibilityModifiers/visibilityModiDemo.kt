package oops.visibilityModifiers

// top-level :
// functions, properties, classes, objects and interfaces can be declared at "top-level"
// directly inside package

// 'public' is used by default, which means that your declarations will be visible everywhere
// 'private' declarations will only be visible inside the file that contains the declaration
// 'internal' declarations will be visible everywhere in the same module
// 'protected' is not available for top-level declarations

/*
    filename : example.kt
    package foo

    private fun foo() {...} // visible inside example.kt

    public var bar: Int = 5 // visible everywhere
        private set // visible inside example.kt

    internal val baz = 6 // visible inside the same module
*/

// class-level :
// 'private' members are visible inside class only
// 'protected' means that the member has same visibility as one marked as 'private', but
// that it is also visible in subclasses
// 'internal' means that any client inside this module who sees the declaring class sees its
// internal members
// 'public' means that any client who sees the declaring class sees its public members
// NOTE : an outer class does not see private members of its inner class
// if you override a 'protected' or an 'internal' member and do not specify the visibility
// explicitly, the overriding member will also have the same visibility as the original

open class Outer {
    private val a = 1
    protected open val b = 2
    internal open val c = 3
    val d = 4 // public by default

    protected class Nested {
        public val e: Int = 5
    }
}

class SubClass : Outer() {
    // a is not visible
    // b,c,d are visible
    // Nested and e are visible
    override val b = 5 // 'b' is protected
    override val c = 7 // 'c' is internal
}

class Unrelated(o: Outer) {
    // o.a, o.b are not visible
    // o.c, o.d are visible (same module)
    // Outer.Nested is not visible, Nested::e is not visible either
}

// local variables, functions, and classes can't have visibility modifiers