package oops.classes

// if primary constructor does not have any annotations or visibility modifiers,
// the constructor keyword can be omitted
class Person constructor(val firstName: String)

// if you want to run some code during object creation,
// use initializer blocks inside class body
// they are declared within init keyword followed by {}
class InitOrderDemo(private val name: String) {
    val firstProperty = "First property : $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property : ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

// primary constructor params can be used in init blocks and also can be used in
// property initializers declared in class body
class Customer(name: String) {
    val customerKey = name.uppercase()
}

// if the constructor has annotations or visibility modifiers,
// the constructor keyword is required and modifiers go before it :
// class Customer public @Inject constructor(name: String) { /*...*/ }

fun main() {
    val person = Person("Jay")
    println(person.firstName)
    InitOrderDemo("Jay")
    val customer = Customer("Rudani")
    println(customer.customerKey)
}