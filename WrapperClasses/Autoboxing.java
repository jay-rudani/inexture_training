package WrapperClasses;

import java.util.ArrayList;

class Autoboxing {

    public static void main(String[] args) {

        char ch = 'J';

        // autoboxing
        Character chr = ch;

        System.out.println(chr);

        ArrayList<Integer> list = new ArrayList<>();
        // autoboxing 'cause arraylist only stores objects
        list.add(25);

        System.out.println(list.get(0));
    }
}
