package ThisKeyword;

// 'this' as a method param
class Example4 {

    int a, b;

    Example4() {
        a = 10;
        b = 20;
    }

    void display(Example4 obj) {
        System.out.println("a = " + a + " b = " + b);
    }

    // returns current class instance
    void get() {
        display(this);
    }

    public static void main(String[] args) {
        Example4 obj = new Example4();
        obj.get();
    }
}
