package Assertion;

class Example1 {

    public static void main(String[] args) {
        int value = 15;
        assert value >= 20 : " Underweight";
        System.out.println("Value is : " + value);

        int age = 17;
        assert age <= 18 : "cannot vote";
        System.out.println("age is : " + age);
    }

}
