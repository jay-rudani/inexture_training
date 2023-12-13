package oops.inlineValueClasses

// Inline classes support some functionality of regular classes. In particular,
// they are allowed to declare properties and functions, have an init block and secondary constructors
@JvmInline
value class Person(private val fullName: String) {
    init {
        require(fullName.isNotEmpty()) {
            "Full name shouldn't be empty"
        }
    }

    constructor(fistName: String, lastName: String) : this("$fistName $lastName") {
        require(lastName.isNotBlank()) {
            "Last name shouldn't be blank"
        }
    }

    val length: Int
        get() = fullName.length

    fun greet() {
        println("Hello, $fullName")
    }
}

// inline classes are allowed to inherit from interfaces
interface Printable {
    fun prettyPrint(): String
}

@JvmInline
value class Name(val s: String) : Printable {
    override fun prettyPrint(): String = "Let's $s!"
}

fun main() {
    val name1 = Person("Jay", "Rudani")
    val name2 = Person("Kishan")
    println("${name1.length} \n ${name2.length}")
    name1.greet()
    name2.greet()

    val name = Name("Kotlin")
    println(name.prettyPrint())
}