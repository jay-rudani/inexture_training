package oops.delegation

// delegating to another property
// a property can delegate its getter and setter to another property
// such delegation is available for both top-level and class properties
// the delegate property can be :
// top-level property, member or an extension property of the same class, member or an extension property of another class
// to delegate property to another property, use :: qualifier in the delegate name
var topLevelInt: Int = 0

class ClassWithDelegate(val anotherClassInt: Int)

class MyClass(private var memberInt: Int, private val anotherClassInstance: ClassWithDelegate) {
    var delegateToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass.extDelegated: Int by ::topLevelInt

fun main() {

    val myClass = MyClass(30, ClassWithDelegate(20))
    println(myClass.delegateToMember)
    println(myClass.delegatedToAnotherClass)
    println(myClass.extDelegated)
    println(myClass.delegatedToTopLevel)

    myClass.delegatedToTopLevel = 45
    println(topLevelInt)
}