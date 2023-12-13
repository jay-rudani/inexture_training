package oops.delegation

// delegated properties take values from this map through string keys,
// which are associated with the names of properties

// this is also works for var properties, use MutableMap instead of Map
class Person(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {

    val person = Person(
        mapOf(
            "name" to "Jay Rudani",
            "age" to 23
        )
    )

    println(person.name)
    println(person.age)
}