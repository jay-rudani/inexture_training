package Array;

import java.util.Scanner;

// for example : matrix mutiplication of 3x3 array
class MultiDimenArray {

    static void matrixMultiplication(int[][] matrix1, int[][] matrix2) {

        int[][] result = new int[3][3];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = matrix1[i][j] * matrix2[i][j];
            }
        }

        // printing resultant array
        System.out.println("Result is :");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // getting matrix1 from user
        System.out.println("Enter matrix 1 elements :");
        int[][] matrix1 = new int[3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // getting matrix2 from user
        System.out.println("Enter matrix 2 elements :");
        int[][] matrix2 = new int[3][3];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2.length; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        matrixMultiplication(matrix1, matrix2);

        scanner.close();
    }
}
