package CollectionFramework.Maps;

import java.util.Map;
import java.util.TreeMap;

class TreeMapExample {

    public static void main(String[] args) {
        Map<String, Integer> wordLengths = new TreeMap<>();

        wordLengths.put("apple", 5);
        wordLengths.put("banana", 6);
        wordLengths.put("cherry", 6);

        int appleLength = wordLengths.get("apple");
        int cherryLength = wordLengths.get("cherry");

        System.out.println("Length of 'apple': " + appleLength);
        System.out.println("Length of 'cherry': " + cherryLength);

        for (Map.Entry<String, Integer> entry : wordLengths.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
