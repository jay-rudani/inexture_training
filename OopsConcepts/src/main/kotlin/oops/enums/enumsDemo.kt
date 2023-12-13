package oops.enums

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class Day(val number: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);

    fun printDay() {
        println("Day is $this")
    }
}

// anonymous classes
// Enum constants can declare their own anonymous classes with their corresponding methods,
// as well as with overriding base methods
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },
    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

// implementing interfaces in enum class
// An enum class can implement an interface (but it cannot derive from a class), providing either
// a common implementation of interface members for all the entries,
// or separate implementations for each entry within its anonymous class
enum class IntArithmetic : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int {
            return t + u
        }
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int {
            return t * u
        }
    };

    override fun applyAsInt(left: Int, right: Int): Int {
        return apply(left, right)
    }
}

fun main() {
    val day = Day.SUNDAY
    day.printDay()

    for (i in Day.entries) {
        println(i)
    }

    println(Day.entries)

    val protocolState = ProtocolState.WAITING
    println(protocolState.signal())

    val a = 13
    val b = 31
    for (i in IntArithmetic.entries) {
        println("$i($a,$b) = ${i.apply(a, b)}")
    }
}