package OOPs.Inheritance;

class Animal {
    void eat() {
        System.out.println("Animal is eating.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking.");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing.");
    }
}

class Heirarchical {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat(); // Inherited from Animal class
        dog.bark(); // Specific to Dog class

        cat.eat(); // Inherited from Animal class
        cat.meow(); // Specific to Cat class
    }
}
