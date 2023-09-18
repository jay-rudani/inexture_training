package CoreJavaPrograms;

import java.util.InputMismatchException;
import java.util.Scanner;

class NumberConversion {

    // method to convert decimal to binary
    static String decimalToBinary(int n) {

        // if input number is 0 then return 0
        if (n == 0) {
            return "0";
        }

        // StringBuilder is used to insert a string at given position
        StringBuilder binary = new StringBuilder();

        // loop will go util number becomes 0
        while (n > 0) {
            // getting remainder of given number
            // ex : 5 % 2 = 1
            int remainder = n % 2;
            // storing remainder at 0 index
            binary.insert(0, remainder);
            // dividing that number by 2
            n = n / 2;
        }

        // returning the string
        return binary.toString();
    }

    // method to convert decimal to octal
    static String decimalToOctal(int n) {

        // if input number is 0 then return 0
        if (n == 0) {
            return "0";
        }

        // StringBuilder is used to insert a string at given position
        StringBuilder octal = new StringBuilder();

        // loop will go util number becomes 0
        while (n > 0) {
            // getting remainder of given number, for octal need to divide by 8
            // ex : 15 % 8 = 7
            int remainder = n % 8;
            // storing remainder at 0 index
            octal.insert(0, remainder);
            // dividing that number by 8
            n = n / 8;
        }

        // returning the string
        return octal.toString();
    }

    // method to convert decimal to hexadecimal
    static String decimalToHexadecimal(int n) {

        // if input number is 0 then return 0
        if (n == 0) {
            return "0";
        }

        // StringBuilder is used to insert a string at given position
        StringBuilder hex = new StringBuilder();

        // loop will go util number becomes 0
        while (n > 0) {
            // getting remainder of given number, for hexadecimal need to divide by 16
            // ex : 31 % 16 = 15
            int remainder = n % 16;

            // for hexadecimal,
            // if remainder <= 9 then storing as it is in string
            if (remainder <= 9)
                hex.insert(0, remainder);
            // decimal to hexadecimal
            // 10 -> A
            // 11 -> B
            // 12 -> C
            // 13 -> D
            // 14 -> E
            // 15 -> F
            else if (remainder == 10)
                hex.insert(0, "A");
            else if (remainder == 11)
                hex.insert(0, "B");
            else if (remainder == 12)
                hex.insert(0, "C");
            else if (remainder == 13)
                hex.insert(0, "D");
            else if (remainder == 14)
                hex.insert(0, "E");
            else if (remainder == 15)
                hex.insert(0, "F");
            n = n / 16;
        }

        // returning the string
        return hex.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            // giving user a choice to select one of the following
            System.out.println("\n1. Convert to Binary");
            System.out.println("2. Convert to Octal");
            System.out.println("3. Convert to Hexadecimal");
            System.out.println("4. Exit");
            System.out.println("Please select an option : ");
            try {
                // storing choice
                int x = scanner.nextInt();
                // declared input variable
                int n;
                // switching between choice
                switch (x) {
                    case 1:
                        System.out.println("Please enter a number : ");
                        n = scanner.nextInt();
                        // input should be greater than/equals to 0
                        if (!(n >= 0))
                            System.out.println("Please enter positive number!");
                        else
                            // printing decimal to binary
                            System.out.println("\nDecimal to Binary value : " + decimalToBinary(n));
                        break;
                    case 2:
                        System.out.println("Please enter a number : ");
                        n = scanner.nextInt();
                        // input should be greater than/equals to 0
                        if (!(n >= 0))
                            System.out.println("Please enter positive number!");
                        else
                            // printing decimal to octal
                            System.out.println("\nDecimal to Octal value : " + decimalToOctal(n));
                        break;
                    case 3:
                        System.out.println("Please enter a number : ");
                        n = scanner.nextInt();
                        // input should be greater than/equals to 0
                        if (!(n >= 0))
                            System.out.println("Please enter positive number!");
                        else
                            // printing decimal to hexadecimal
                            System.out.println("\nDecimal to Hexadecimal value : " + decimalToHexadecimal(n));
                        break;
                    case 4:
                        // used to terminate the progam
                        System.exit(0);
                    default:
                        System.out.println("\nPlease select a valid option!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a number!");
                // this is used to prevent from going into infinite loop
                scanner.nextLine();
            }
        } while (true);

    }
}
