package CoreJavaPrograms;

import java.util.InputMismatchException;
import java.util.Scanner;

class FibonacciDiamond {

    // firstTerm, secondTerm for fibonacci series and i,j for loop
    static int firstTerm = 0, secondTerm = 1, i, j;

    static void printFibonacciFirstHalfDiamond(int n) {
        // this is used for spacing
        int space = n - 1;
        // this if-else for better output according to input
        if (n <= 4) {
            // main outer loop will from 1 to n (input)
            for (j = 1; j <= n; j++) {
                // this loop for spacing
                for (i = 1; i <= space; i++) {
                    System.out.print("\t");
                }
                space--;
                // this loop will print fibonacci series numbers
                for (i = 1; i <= 2 * j - 1; i++) {
                    // this format is used for better space
                    System.out.printf("%5d", firstTerm);
                    System.out.print("\t");
                    // sum of firstTeam and secondTerm stored as nextTerm
                    int nextTerm = firstTerm + secondTerm;
                    // firstTerm will become secondTerm
                    firstTerm = secondTerm;
                    // secondTerm will become nextTerm
                    secondTerm = nextTerm;
                }
                System.out.println("");
            }
        } else {
            for (j = 1; j <= n; j++) {
                for (i = 1; i <= space; i++) {
                    System.out.print("\t");
                }
                space--;
                for (i = 1; i <= 2 * j - 1; i++) {
                    System.out.printf("%7d", firstTerm);
                    System.out.print("\t");
                    int nextTerm = firstTerm + secondTerm;
                    firstTerm = secondTerm;
                    secondTerm = nextTerm;
                }
                System.out.println("");
            }
        }
    }

    static void printFibonacciSecondHalfDiamond(int n) {
        int space = 1;
        if (n <= 4) {
            for (j = 1; j <= n - 1; j++) {
                for (i = 1; i <= space; i++) {
                    System.out.print("\t");
                }
                space++;
                for (i = 1; i <= 2 * (n - j) - 1; i++) {
                    System.out.printf("%5d", firstTerm);
                    System.out.print("\t");
                    int nextTerm = firstTerm + secondTerm;
                    firstTerm = secondTerm;
                    secondTerm = nextTerm;
                    // System.out.print("*");
                }
                System.out.println("");
            }
            System.out.println();
        } else {
            for (j = 1; j <= n - 1; j++) {
                for (i = 1; i <= space; i++) {
                    System.out.print("\t");
                }
                space++;
                for (i = 1; i <= 2 * (n - j) - 1; i++) {
                    System.out.printf("%7d", firstTerm);
                    System.out.print("  ");
                    int nextTerm = firstTerm + secondTerm;
                    firstTerm = secondTerm;
                    secondTerm = nextTerm;
                    // System.out.print("*");
                }
                System.out.println("");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("\n1. Print Fibonacci in Diamond Pattern ");
                System.out.println("2. exit");
                System.out.print("Select option : ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter number between 1 to 5 :");
                        int number = scanner.nextInt();
                        if (number >= 1 && number <= 5) {
                            printFibonacciFirstHalfDiamond(number);
                            printFibonacciSecondHalfDiamond(number);
                        } else {
                            System.out.println("Please enter a number between 1 to 5");
                        }
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Enter valid option!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter number!");
                scanner.nextLine();
            }
        } while (true);
    }
}
