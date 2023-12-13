package oops.interfaces

// interfaces can contain declarations of abstract methods, as well as method implementations
// what makes them different from abstract classes is that interfaces cannot store state
// they can have properties, but these need to be abstract or provide accessor implementations

interface MyInterface {
    val prop: Int // abstract
    fun bar()
    val propertyImplementation: String
        get() = "foo"

    fun foo() {
        // optional body
        println(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
    override fun foo() {
        TODO("Not yet implemented")
    }

    override fun bar() {
        TODO("Not yet implemented")
    }
}

interface Named {
    val name: String
}

interface Person : Named {
    val firstName: String
    val lastName: String
    override val name: String get() = "$firstName $lastName"
}

data class Employee(
    // implementing 'name' is not required
    override val lastName: String,
    override val firstName: String,
) : Person