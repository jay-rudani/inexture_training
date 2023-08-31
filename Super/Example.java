package Super;

class Parent {

    int value;

    Parent(int value) {
        this.value = value;
    }

    void display() {
        System.out.println("value is parent : " + value);
        System.out.println("This is the parent class");
    }
}

class Child extends Parent {

    int childValue;

    Child(int value, int childValue) {
        super(value);
        this.childValue = childValue;
    }

    @Override
    void display() {
        super.display();
        System.out.println("value in child : " + childValue);
        System.out.println("This is the child class");
    }
}

class Example {

    public static void main(String[] args) {
        Child child = new Child(10, 20);
        child.display();
    }
}
