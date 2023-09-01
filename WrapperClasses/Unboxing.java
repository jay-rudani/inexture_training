package WrapperClasses;

import java.util.ArrayList;

class Unboxing {

    public static void main(String[] args) {
        Character chr = 'J';
        // unboxing
        char ch = chr;
        System.out.println(ch);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(25);

        // unboxing
        int num = list.get(0);

        System.out.println(num);
    }
}
