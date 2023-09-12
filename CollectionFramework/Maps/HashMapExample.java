package CollectionFramework.Maps;

import java.util.HashMap;
import java.util.Map;

class HashMapExample {

    public static void main(String[] args) {

        Map<String, Integer> population = new HashMap<>();

        population.put("USA", 331_002_651);
        population.put("China", 1_439_323_776);
        population.put("India", 1_366_418_583);

        int usaPopulation = population.get("USA");
        int chinaPopulation = population.get("China");

        System.out.println("Population of USA: " + usaPopulation);
        System.out.println("Population of China: " + chinaPopulation);

        for (Map.Entry<String, Integer> entry : population.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
