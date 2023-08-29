package Loop;

class Loops {

    public static void main(String[] args) {

        // for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("For loop : " + i);
        }

        // while loop
        int count = 0;
        while (count < 4) {
            System.out.println("While loop : " + count);
            count++;
        }

        // do-while loop
        int condition = 5;
        do {
            System.out.println("do-while loop : " + condition);
            condition--;

        } while (condition != 0);

        // nested while
        int outer = 1;
        while (outer <= 3) {
            int inner = 1;
            while (inner <= 3) {
                System.out.println("Outer : " + outer + ", Inner : " + inner);
                inner++;
            }
            outer++;
        }

        System.out.println("enhanced for loop (for-each) :");
        int[] numbers = new int[] { 1, 2, 3, 4, 5 };
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
