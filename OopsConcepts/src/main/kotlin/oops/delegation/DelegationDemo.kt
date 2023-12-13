package oops.delegation

interface Animal {
    val name: String
    val canFly: Boolean
    fun makeSound(): String
    fun move(direction: String)
}

class BirdName{

}

class Bird : Animal {
    override val name: String
        get() = "Bird"
    override val canFly: Boolean
        get() = true

    override fun makeSound(): String {
        println("this bird crows")
        return "crows"
    }

    override fun move(direction: String) {
        println("this bird is flying towards the $direction")
    }
}

class Crow : Animal by Bird()

fun main() {

    val crow = Crow()
    crow.makeSound()
    crow.move("UP")
}