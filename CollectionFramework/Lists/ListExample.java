package CollectionFramework.Lists;

import java.util.*;

class ListExample {

    public static void main(String[] args) {

        ArrayList<String> fruitsList = new ArrayList<>();
        fruitsList.add("Apple");
        fruitsList.add("Banana");
        fruitsList.add("Orange");
        System.out.println("Fruits list : " + fruitsList);

        ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList("Java", "C", "C++", "GoLang", "Python"));
        System.out.println("Programming languages list : " + programmingLanguages);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Jay Rudani", 23, "Rajkot"));
        persons.add(new Person("Kishan Rudani", 28, "Rajkot"));

        System.out.println("persons : " + persons);

        // List<Integer> numbersList = new ArrayList(List.of(1, 2, 3, 4, 5));
        // System.out.println("Numbers list : " + numbersList);
    }
}
