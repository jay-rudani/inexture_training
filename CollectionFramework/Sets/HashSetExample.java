package CollectionFramework.Sets;

import java.util.HashSet;
import java.util.Set;

class HashSetExample {

    public static void main(String[] args) {

        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(null);
        System.out.println(numbers);

        numbers.remove(1);
        System.out.println(numbers);

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        System.out.println(numbers);
        System.out.println(numbers.size());

    }
}
