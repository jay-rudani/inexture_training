package oops.classes

// a class may be declared abstract, along with some or all of its members
// an abstract member does not have an implementation in its class
// do not need to annotate abstract classes or function with 'open'

abstract class Polygon {
    abstract fun draw()
}

class Rectangle : Polygon() {
    override fun draw() {

    }
}

open class Hexagon {
    open fun draw() {
        // some default polygon drawing method
    }
}

abstract class WildShape : Hexagon() {
    // classes that inherit WildShape need to provide their own
    // draw method instead of using the default on Polygon
    abstract override fun draw()
}

class Circle : WildShape() {
    override fun draw() {
        TODO("Not yet implemented")
    }

}