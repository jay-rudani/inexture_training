package ThisKeyword;

// 'this' as an argument in constructor
class A {

    Example6 obj;

    A(Example6 obj) {
        this.obj = obj;
        obj.display();
    }
}

class Example6 {

    int x = 5;

    Example6() {
        new A(this);
    }

    void display() {
        System.out.println("Value of x : " + x);
    }

    public static void main(String[] args) {
        new Example6();
    }
}