package ThisKeyword;

// 'this' to return current class instance
class Example3 {

    int a, b;

    Example3() {
        a = 10;
        b = 20;
    }

    Example3 get() {
        return this;
    }

    void display() {
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main(String[] args) {
        Example3 obj = new Example3();
        obj.get().display();
    }
}
