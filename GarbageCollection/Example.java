package GarbageCollection;

class Example {

    public void finalize() {
        System.out.println("object is garbage collected.");
    }

    public static void main(String[] args) {

        Example obj1 = new Example();
        Example obj2 = new Example();
        obj1 = obj2;
        System.gc();
    }
}
