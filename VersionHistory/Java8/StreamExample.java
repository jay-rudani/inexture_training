package VersionHistory.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [ id= " + id + ", name= " + name + ", price= " + price + " ]";
    }

}

class StreamExample {

    public static void main(String[] args) {

        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        System.out.println(productsList);

        List<String> priceGrtThan28k = productsList
                .stream()
                .filter(p -> p.price > 28000)
                .map(p -> p.name)
                .collect(Collectors.toList());
        System.out.println(priceGrtThan28k);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(500);
        numbers.add(300);
        numbers.add(200);
        numbers.add(400);
        int sumOfNums = numbers.stream().reduce(0, (a, b) -> (a + b));
        System.out.println(sumOfNums);
    }
}
