package Methods;

public class StaticAndNonStaticMethods {

    static int x = 10;
    int y = 22;

    static int add(int a, int b) {
        System.out.println("printing static x : " + x);
        System.out.println("printing instance var y : " + new StaticAndNonStaticMethods().y);
        return a + b;
    }

    int multiply() {
        return x * y;
    }

    public static void main(String[] args) {
        System.out.println(add(10, 12));
        StaticAndNonStaticMethods obj = new StaticAndNonStaticMethods();
        System.out.println(obj.multiply());
    }
}
