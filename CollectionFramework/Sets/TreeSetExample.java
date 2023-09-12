package CollectionFramework.Sets;

import java.util.TreeSet;

class TreeSetExample {

    public static void main(String[] args) {

        TreeSet<String> fruits = new TreeSet<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Cherry");
        fruits.add("Date");
        fruits.add("Banana");

        System.out.println("In sorted order : " + fruits);
        System.out.println(fruits.contains("Cherry"));
        fruits.remove("Date");
        System.out.println(fruits);

        for (String s : fruits) {
            System.out.println(s);
        }
    }
}
