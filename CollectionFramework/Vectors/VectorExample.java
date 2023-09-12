package CollectionFramework.Vectors;

import java.util.Vector;

class VectorExample {

    public static void main(String[] args) {

        Vector<Integer> numbers = new Vector<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
        numbers.add(null);
        System.out.println(numbers);
        System.out.println(numbers.get(5));
        numbers.remove(5);
        System.out.println(numbers.size());

        for (int x : numbers) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
