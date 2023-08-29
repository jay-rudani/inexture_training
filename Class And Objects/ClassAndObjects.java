// a class name should always start with Uppercase
// a class is a "blueprint" that defines state and behavior of objects
class ClassAndObjects {

    int x = 10;

    public static void main(String[] args) {

        // an object is an instance of a class
        // object that holds state and behavior of class like methods and fields
        // a java program can have any no. of objects
        // object is created with new keyword
        ClassAndObjects obj1 = new ClassAndObjects();
        // will print value of x = 10
        System.out.println(obj1.x);
    }
}