package Operators.TernaryAndInstanceOf;

class TernaryAndInstanceOf {

    static String checkOddEven(int i) {
        // ternary ? :
        // condition ? if true : false
        return (i % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 6; i++) {
            System.out.println(i + " is " + checkOddEven(i));
        }

        String str = new String("Jay Rudani");
        // here instanceof is to check that str is an object of type String or not
        // returns true or false
        System.out.println(str instanceof String);
    }
}
