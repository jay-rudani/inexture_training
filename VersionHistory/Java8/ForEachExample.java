package VersionHistory.Java8;

import java.util.ArrayList;
import java.util.List;

class ForEachExample {

    public static void main(String[] args) {

        List<String> gamesList = new ArrayList<>();
        gamesList.add("Football");
        gamesList.add("Cricket");
        gamesList.add("Chess");
        gamesList.add("Hocky");

        System.out.println("-- iterating by passing lambda --");
        gamesList.forEach(games -> System.out.println(games));

        System.out.println("-- iterating by method reference --");
        gamesList.forEach(System.out::println);
    }
}
