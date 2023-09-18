package CoreJavaPrograms;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 1         1
 * 1 2     2 1
 * 1 2 3 3 2 1
 */

class Pattern1 {

    static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            if (n >= 10) {
                for (int j = 1; j <= i; j++)
                    System.out.print(j);
                for (int k = i * 2; k < n * 2; k++) {
                    System.out.print(" ");
                }
                if (i < n)
                    System.out.print("  ");
                for (int l = i; l >= 1; l--) {
                    System.out.print(l);
                }
                System.out.println();
            } else {
                for (int j = 1; j <= i; j++)
                    System.out.print(j);
                for (int k = i * 2; k < n * 2; k++) {
                    System.out.print(" ");
                }
                for (int l = i; l >= 1; l--)
                    System.out.print(l);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("\n1. Print Pattern");
                System.out.println("2. Exit");
                System.out.print("Select option : ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter a number : ");
                        int n = scanner.nextInt();
                        printPattern(n);
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        System.out.println("Please select valid option!");

                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
            }
        } while (true);
    }
}
