package ThisKeyword;

// 'this' refer to the current class instance variables
class Example1 {

    int a, b;

    Example1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void display() {
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main(String[] args) {
        Example1 obj = new Example1(10, 20);
        obj.display();
    }
}
