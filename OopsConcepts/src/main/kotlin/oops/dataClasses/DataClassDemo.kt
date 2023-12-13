package oops.dataClasses

// data classes in kotlin are classes whose main purpose is to hold data
// it comes with additional member functions that allows you to print an instance to readable output,
// compare instances, copy instances and more
// in data class, primary constructor must have at least one param
// all primary constructor params must be marked with val/var
// data classes can't be abstract, open, sealed and inner

data class Person(val name: String) {
    var age: Int = 0
//    fun copy(name: String = this.name, age: Int = this.age) = User(name, age)
}

data class User(val name: String = "", val age: Int = 0)

fun main() {

    val person1 = Person("John")
    val person2 = Person("John")
    person1.age = 10
    person2.age = 20

    // in this, only the name property can be used inside .toString(), .equals(), .hashCode(), .copy()
    // implementations, and there is only one component function .component1()
    // the age property can't be used inside those functions

    // if two Person objects have different ages but the same name, then they are treated as equal
    // this is because the .equals() function can only check for equality of the name property
    println("person1 == person2 : ${person1 == person2}")
    println("person1 with age ${person1.age} : $person1")
    println("person2 with age ${person2.age} : $person2")

    val jack = User(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(olderJack.name)
}
