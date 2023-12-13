package oops.classes

class Rectangle1(val width: Int, val height: Int) {

    val area: Int
        get() = this.width * this.height

    // you can omit type if it can be inferred from the getter :
    // val area get() = this.x * this.y

    @Suppress("RedundantGetter", "RedundantSetter")
    var stringRepresentation: String = ""
        get() = field
        set(value) {
            field = value
        }
}

class Temp {
    // the field identifier can only be used in the accessors of the property
    var counter = 0 // the initializer assigns the backing field directly
        set(value) {
            if (value >= 0)
                field = value
            // counter = value // ERROR StackOverflow : Using actual name 'counter' would make setter recursive
        }

    // there would be no backing field in the following cases :
    // val isEmpty: Boolean
    //      get() = this.size == 0

    // if you want to do something that does not fit into this implicit backing field scheme,
    // you can always fall back to having a backing property :
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null)
                _table = HashMap()
            return _table ?: throw AssertionError("Set to null")
        }
}

fun main() {
    val rectangle = Rectangle1(3, 4)
    println("Width : ${rectangle.width}, Height : ${rectangle.height}, Area : ${rectangle.area}")
    rectangle.stringRepresentation = "Jay Rudani"
    println(rectangle.stringRepresentation)
}