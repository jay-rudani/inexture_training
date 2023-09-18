package CoreJavaPrograms;

import java.util.InputMismatchException;
import java.util.Scanner;

class InsertionSort {

    static Scanner scanner = new Scanner(System.in);
    static int[] array;

    // method for sorting an array
    public static void sort(int[] array) {
        // loop starts from 1 to length of array
        // for ex : consider this arr[] = {5,2,3,1,4}
        for (int i = 1; i < array.length; i++) {
            // storing current iteration element as key
            int key = array[i]; // key = 2
            // for another loop
            int j = i - 1; // j = 0

            // loop will start from i-1 and run till =0
            // arr[0] = 5 > 2, true
            while (j >= 0 && array[j] > key) {
                // arr[j+1] = arr[1] = arr[0] = 5
                array[j + 1] = array[j];
                // j = -1
                j = j - 1;
            }
            // arr[-1+1] = arr[0] = key = 2
            array[j + 1] = key;
            // now arr[] will look like {2,5,3,1,4} after 1st iteration of for loop
        }
    }

    // method used to get size of the array
    public static void getSize() {
        // if there is no array is initialized
        // then handling null pointer exception
        try {
            System.out.println("Size is : " + array.length);
        } catch (NullPointerException ex) {
            System.out.println("Array is empty! : " + ex.getMessage());
        }
    }

    // method used for adding element in the array
    public static void addElements(int size) {
        System.out.println("Enter " + size + " element(s) :");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
    }

    // method used to at element at specific index
    public static void addAtSpecificIndex(int index, int element) {
        // if there is no array is initialized
        // then handling null pointer exception
        try {
            // dividing array into 2 parts as leftArray and rightArray from index provided
            // by user
            // Size of leftArray is always be index + 1
            int[] leftArray = new int[index + 1];
            int[] rightArray = new int[array.length];

            // storing array elements in leftArray from 0 to index (exclude)
            for (int i = 0; i < index; i++) {
                leftArray[i] = array[i];
            }
            // adding element to leftArray at provided index
            leftArray[index] = element;
            // using temp as an index of rightArray as starting from 0 for storing remaining
            // elements of the array
            int tempIndex = 0;
            for (int i = index; i < array.length; i++) {
                rightArray[tempIndex] = array[i];
                // increasing index
                tempIndex++;
            }

            // reinitializing old array with new length
            array = new int[array.length + 1];
            // storing elements of leftArray to reinitialized array
            for (int i = 0; i < index + 1; i++) {
                array[i] = leftArray[i];
            }
            tempIndex = 0;
            // storing elements of rightArray to reinitialized array
            for (int i = index + 1; i < rightArray.length + 1; i++) {
                array[i] = rightArray[tempIndex];
                tempIndex++;
            }

        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            System.out.println("Index is out of size! or Array is yet to be initialized : " + ex.getMessage());
        }
    }

    // method used to remove element from specific index
    public static void removeAtSpecificIndex(int index) {
        // if there is no array is initialized
        // then handling null pointer exception
        try {
            // dividing array into 2 parts leftArray and rightArray
            // size of leftArray is always be value of index provided by user
            int[] leftArray = new int[index];
            int[] rightArray = new int[array.length];

            // storing elements in left array
            for (int i = 0; i < index; i++) {
                leftArray[i] = array[i];
            }
            // tempIndex for rightArray for storing element from 0
            int tempIndex = 0;
            // storing elements starting from index + 1 which means excluding current
            // element
            for (int i = index + 1; i < array.length; i++) {
                rightArray[tempIndex] = array[i];
                tempIndex++;
            }

            // reinitializing old array with one less length
            array = new int[array.length - 1];
            // storing elements of leftArray to reinitialized array
            for (int i = 0; i < leftArray.length; i++) {
                array[i] = leftArray[i];
            }
            tempIndex = 0;
            // storing elements of rightArray to reinitialized array
            for (int i = index; i < rightArray.length - 1; i++) {
                array[i] = rightArray[tempIndex];
                tempIndex++;
            }
            System.out.println();
        } catch (ArrayIndexOutOfBoundsException | NullPointerException ex) {
            System.out.println("Index is out of size! or Array is yet to be initialized : " + ex.getMessage());
        }
    }

    // method used for printing the array in sorted manner
    public static void printArray() {
        // handling exception for no elements
        try {
            // sorting the array
            sort(array);
            // printing
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        } catch (NullPointerException ex) {
            System.out.println("Array is empty! : " + ex.getMessage());
        }
    }

    public static void main(String[] args) {

        do {
            // giving user a choice to select a option
            System.out.println("\n1. Initialze array with size and add elements");
            System.out.println("2. Add at specific index");
            System.out.println("3. Remove at specific index");
            System.out.println("4. Print sorted Array");
            System.out.println("5. Check size of the array");
            System.out.println("6. Exit");
            System.out.print("Select an option : ");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter size of the array :");
                        int size = scanner.nextInt();
                        // size should be positive
                        if (!(size > 0))
                            System.out.println("Please enter valid size");
                        else {
                            array = new int[size];
                            addElements(size);
                        }
                        break;
                    case 2:
                        System.out.println("Enter index : ");
                        int index1 = scanner.nextInt();
                        // index should be positive
                        if (!(index1 >= 0))
                            System.out.println("Please enter valid index");
                        else {
                            System.out.println("Enter element : ");
                            int element = scanner.nextInt();
                            addAtSpecificIndex(index1, element);
                        }
                        break;
                    case 3:
                        System.out.println("Enter index : ");
                        int index2 = scanner.nextInt();
                        // index should be positive
                        if (!(index2 >= 0))
                            System.out.println("Please enter valid index");
                        else
                            removeAtSpecificIndex(index2);
                        break;
                    case 4:
                        // this will print array
                        printArray();
                        break;
                    case 5:
                        // this will print size
                        getSize();
                        break;
                    case 6:
                        // to terminate program
                        System.exit(0);
                    default:
                        System.out.println("Please select valid option!");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter number!");
                scanner.nextLine();
            }
        } while (true);
    }
}
