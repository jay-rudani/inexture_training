package NestedClass;

class LocalInnerClass {

    public static void someMethod() {
        final int x = 10;

        class LocalClass {
            void display() {
                System.out.println(x);
            }
        }

        LocalClass localClassObj = new LocalClass();
        localClassObj.display();
    }

    public static void main(String[] args) {
        someMethod();
    }
}
