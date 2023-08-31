package Constructor;

class ConstructorChaining {

    int x;

    ConstructorChaining() {
        this(100); // calling parameterized constructor
    }

    ConstructorChaining(int value) {
        x = value;
    }

    public static void main(String[] args) {
        System.out.println("Value of x : " + new ConstructorChaining().x);
    }
}
