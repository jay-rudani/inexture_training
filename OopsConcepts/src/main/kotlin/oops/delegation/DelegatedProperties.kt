package oops.delegation

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Delegate {
    operator fun getValue(classRef: Any?, property: KProperty<*>): String {
        return "$classRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $classRef")
    }
}

class Example {
    var p: String by Delegate()
}

// lazy() is a function that takes lambda and returns an instance of Lazy<T>,
// which can serve as a delegate for implementing a lazy property
// the first call to get() executes the lambda passed to lazy() and remembers the result
// subsequent calls to get() simply return the remembered result
// by default evaluation of lazy properties is synchronized, the value is only computed in one thread,
// but all threads will see the same value
// if you want to allow multiple threads to execute it simultaneously, pass
// LazyThreadSafetyMode.PUBLICATION as param to lazy()
val lazyValue: String by lazy {
    println("Computed")
    "Hello, World!"
}

class User {

    // Delegates.observable() takes to args : the initial value and a handler for modifications
    // the handler is called every time you assign to the property (after the assignment has been performed)
    var name: String by Delegates.observable("<no-name>") { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}

fun main() {
    val e = Example()
    e.p = "Hello"
    println(e.p)

    println(lazyValue)

    val user = User()
    user.name = "first"
    user.name = "second"
}