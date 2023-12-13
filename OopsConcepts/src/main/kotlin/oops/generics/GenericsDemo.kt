package oops.generics

// generics are used to create classes, interfaces, and functions that can work with
// different types while providing type safety

// the 'in' and 'out' keywords are used in context of generics to specify variance

// when you declare a type parameter as covariant using 'out', you are telling the compiler that
// the type parameter can only appear in the 'out' positions of the class or interface,
// meaning it can only be used as the return type of methods and not as a parameter type

// on the other hand, hen you declare a type parameter as contravariant using in,
// you're telling the compiler that the type parameter can only appear in 'in' positions,
// meaning it can only be used as a parameter type and not as a return type.

interface Consumer<in T> {
    fun consume(item: T)
}

interface Producer<out T> {
    fun produce(): T
}

fun main() {

    val stringProducer: Producer<String> = object : Producer<String> {
        override fun produce(): String {
            return "Hello, Kotlin!"
        }
    }

    val anyProducer: Producer<Any> = stringProducer
    println(anyProducer.produce())

    val anyConsumer: Consumer<Any> = object : Consumer<Any> {
        override fun consume(item: Any) {
            println("Consuming : $item")
        }
    }

    val stringConsumer: Consumer<String> = anyConsumer
    stringConsumer.consume("Hello, Kotlin!")
}