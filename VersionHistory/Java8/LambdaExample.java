package VersionHistory.Java8;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface // optional
interface Drawable {
    public void draw();
}

interface Sayable {
    public String say(String name);
}

interface Addable {
    public int add(int a, int b);
}

class LambdaExample {

    public static void main(String[] args) {
        int width = 10;
        List<String> list = new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        Drawable d1 = () -> {
            System.out.println("Drawing : " + width);

        };

        Sayable s1 = (s) -> {
            return "Hello " + s;
        };

        Addable add = (a, b) -> (a + b);

        d1.draw();
        System.out.println(s1.say("Jay"));
        System.out.println(add.add(10, 12));

        list.forEach(n -> System.out.println(n));
    }
}
