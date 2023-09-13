package VersionHistory.Java8;

import java.util.function.BiFunction;

interface Sayable1 {
    void say();
}

class Arithmetic {
    public static int add(int x, int y) {
        return x + y;
    }
}

interface Messageable {
    Message getMessage(String msg);
}

class Message {
    Message(String msg) {
        System.out.println(msg);
    }
}

public class MethodReferenceExample {

    public static void saySomething() {
        System.out.println("Hello, this is static method");
    }

    public void say() {
        System.out.println("Hello, this is non-static method");
    }

    public static void main(String[] args) {

        // static method reference
        Sayable1 sayable = MethodReferenceExample::saySomething;
        sayable.say();

        BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
        int result = adder.apply(200, 150);
        System.out.println(result);

        // instance method reference
        MethodReferenceExample methodReferenceExample = new MethodReferenceExample();
        Sayable1 sayable1 = methodReferenceExample::say;
        sayable1.say();

        Sayable1 sayable2 = new MethodReferenceExample()::say; // anonymous object
        sayable2.say();

        // constructor reference
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}
