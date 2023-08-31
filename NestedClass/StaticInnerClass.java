package NestedClass;

class StaticInnerClass {

    static int a = 10;

    public static class StaticNestedClass {
        void display() {
            // printing value of a that is member of outer class
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        StaticInnerClass.StaticNestedClass nestedObj = new StaticInnerClass.StaticNestedClass();
        nestedObj.display();
    }
}
