package ThisKeyword;

// 'this' to invoke current class constructor
class Example2 {

    int a, b;

    Example2() {
        this(10, 20);
        System.out.println("inside default constructor");
    }

    Example2(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("inside parameterized constructor");
    }

    public static void main(String[] args) {

        Example2 obj = new Example2();
        System.out.println("a = " + obj.a + " b = " + obj.b);
    }
}
