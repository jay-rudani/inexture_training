package ToString;

// toString() is a method that defined in the Object class and can be overridden by subclasses
// this is used to convert an object's state or content into a human-readable string representation
// default implementation of toString() returns a string containing the class name, followed by @ and
// object's hash code in hexadecimal format
class Demo {

    String name;
    int age;

    Demo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person { name = " + name + ", age = " + age + " }";
    }

    public static void main(String[] args) {
        Demo obj = new Demo("Jay", 23);
        System.out.println(obj.toString());
    }
}
