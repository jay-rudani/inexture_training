package ThisKeyword;

// 'this' to invoke current class method
class Example5 {

    void display() {

        this.show();
        System.out.println("Inside display() method");
    }

    void show() {
        System.out.println("Inside show() method");
    }

    public static void main(String[] args) {
        Example5 obj = new Example5();
        obj.display();
    }
}
