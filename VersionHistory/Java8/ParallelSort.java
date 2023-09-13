package VersionHistory.Java8;

import java.util.Arrays;

// java provides a new additional feature in Array class which is used to sort array elements parallel
// New methods has added to java.util.Arrays package that use the JSR 166 Fork/Join parallelism common pool to provide sorting of arrays in parallel

class ParallelSort {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 5, 7, 3, 0 };
        System.out.println("Before sorting :");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.parallelSort(arr);

        System.out.println("After sorting :");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr1 = { 5, 8, 1, 0, 6, 9, 50, -3 };
        System.out.println("Before sorting :");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.parallelSort(arr1, 0, 4);

        System.out.println("After sorting :");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
