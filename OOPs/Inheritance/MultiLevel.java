package OOPs.Inheritance;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Mammal extends Animal {
    void run() {
        System.out.println("Mammal is running");
    }
}

class Dog extends Mammal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class MultiLevel {

    public static void main(String[] args) {
        Dog myDog = new Dog();

        myDog.eat(); // Inherited from Animal class
        myDog.run(); // Inherited from Mammal class
        myDog.bark(); // Part of Dog class
    }
}
