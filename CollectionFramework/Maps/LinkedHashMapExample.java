package CollectionFramework.Maps;

import java.util.LinkedHashMap;
import java.util.Map;

class LinkedHashMapExample {

    public static void main(String[] args) {
        Map<String, Integer> scores = new LinkedHashMap<>();

        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);

        int aliceScore = scores.get("Alice");
        int bobScore = scores.get("Bob");

        System.out.println("Alice's score: " + aliceScore);
        System.out.println("Bob's score: " + bobScore);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
