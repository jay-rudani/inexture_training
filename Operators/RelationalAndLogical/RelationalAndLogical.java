package Operators.RelationalAndLogical;

class RelationalAndLogical {

    public static void main(String[] args) {

        int x = 10;
        System.out.println("x = " + x);
        if (x > 5) {
            System.out.println("x is greater than 5");
        }
        if (x < 100) {
            System.out.println("x is less than 100");
        }
        if (x >= 10) {
            System.out.println("x is greater than/equal to 10");
        }
        if (x <= 10) {
            System.out.println("x is less than/equal to 10");
        }
        if (x != 20) {
            System.out.println("x is not equal to 20");
        }
        if (x >= 10 && x < 50) {
            System.out.println("x is greater than/equal to 10 but less than 50");
        }
        if (x == 100 || x < 50) {
            System.out.println("x equal to 100 or less than 50");
        }
        if (!false) {
            System.out.println("this is true");
        }
    }
}
