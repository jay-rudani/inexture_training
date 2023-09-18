package CoreJavaPrograms;

import java.util.InputMismatchException;
import java.util.Scanner;

class SquareSpiral {

    public static void generateSpiralClockwise(int n) {
        // declaring and initializing n x n array
        int[][] spiral = new int[n][n];
        // this is used to store number in 2D array
        int num = 1;
        // left and top used to top-left corner and bottom and right used for
        // bottom-right corner
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        // this loop will go till num > n * n
        while (num <= n * n) {
            // Traverse right
            // in first row, starting from left till right, it will store numbers in
            // sequence from left to right
            for (int i = left; i <= right; i++) {
                spiral[top][i] = num++;
            }
            // switch to next row
            top++;

            // Traverse down
            // from second row, in last column, it will store numbers in
            // sequence from top to bottom
            for (int i = top; i <= bottom; i++) {
                spiral[i][right] = num++;
            }
            // switch to previous column
            right--;

            // Traverse left
            // from previous column till left, it will store numbers in
            // sequence from right to left
            for (int i = right; i >= left; i--) {
                spiral[bottom][i] = num++;
            }
            // switch to previous row
            bottom--;

            // Traverse up
            // now storing numbers bottom-left to top
            for (int i = bottom; i >= top; i--) {
                spiral[i][left] = num++;
            }
            // switch to next column
            left++;
        }

        printSpiral(spiral);
    }

    public static void generateSpiralAntiClockwise(int n) {
        // declaring and initializing n x n array
        int[][] spiral = new int[n][n];
        // this is used to store number in 2D array
        int num = 1;
        // left and top used to top-left corner and bottom and right used for
        // bottom-right corner
        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (num <= n * n) {
            // Traverse left
            // for anti-clockwise, storing numbers in sequence from right to left
            for (int i = right; i >= left; i--) {
                spiral[top][i] = num++;
            }
            // switch to next tow
            top++;

            // Traverse down
            // now storing numbers in sequence from top to bottom (left most column)
            for (int i = top; i <= bottom; i++) {
                spiral[i][left] = num++;
            }
            // switch to next column
            left++;

            // Traverse right
            // storing numbers in sequence from left to right
            for (int i = left; i <= right; i++) {
                spiral[bottom][i] = num++;
            }
            // switch to previous row
            bottom--;

            // Traverse up
            // storing numbers in sequence from bottom to top
            for (int i = bottom; i >= top; i--) {
                spiral[i][right] = num++;
            }
            // switch to previous column
            right--;
        }

        printSpiral(spiral);
    }

    public static void printSpiral(int[][] spiral) {
        int size = spiral.length;
        // Print the spiral pattern
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%2d ", spiral[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        do {
            // giving user a choice to select one of the following
            System.out.println("\n1. Clockwise Spiral");
            System.out.println("2. AntiClockwise Spiral");
            System.out.println("3. Exit");
            System.out.print("Select option : ");
            try {
                // storing choice
                int choice = scanner.nextInt();
                // switching between choice
                switch (choice) {
                    case 1:
                        System.out.println("Enter size n x n : ");
                        int clockwiseSize = scanner.nextInt();
                        // if size is negative then do nothing
                        if (!(clockwiseSize > 0))
                            System.out.println("Please enter positive value!");
                        // otherwise call method for clockwise printing
                        else
                            generateSpiralClockwise(clockwiseSize);
                        break;

                    case 2:
                        System.out.println("Enter size n x n : ");
                        int antiClockwiseSize = scanner.nextInt();
                        // if size is negative then do nothing
                        if (!(antiClockwiseSize > 0))
                            System.out.println("Please enter positive value!");
                        // otherwise call method for anti-clockwise printing
                        else
                            generateSpiralAntiClockwise(antiClockwiseSize);
                        break;
                    case 3:
                        // used to terminate the progam
                        System.exit(0);
                    default:
                        System.out.println("Please select valid option!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a number!");
                // this is used to prevent from going into infinite loop
                scanner.nextLine();
            }
        } while (true);
    }
}
