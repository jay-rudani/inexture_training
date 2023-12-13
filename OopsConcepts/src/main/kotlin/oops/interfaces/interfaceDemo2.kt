package oops.interfaces

interface A {
    fun foo() {
        println("A")
    }

    fun bar()
}

interface B {
    fun foo() {
        println("B")
    }

    fun bar() {
        println("B-bar")
    }
}

class C : A {
    override fun bar() {
        println("A-bar")
    }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super.bar()
    }

//    override fun foo() {
//        TODO("Not yet implemented")
//    }
}