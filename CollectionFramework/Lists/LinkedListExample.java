package CollectionFramework.Lists;

import java.util.LinkedList;

class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.addFirst(6);
        numbers.addLast(7);
        numbers.add(2, 10);

        System.out.println(numbers);
        System.out.println(numbers.size());

        numbers.remove(3);
        System.out.println(numbers);
    }
}
