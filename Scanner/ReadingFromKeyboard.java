package Scanner;

import java.util.Scanner;

class ReadingFromKeyboard {

    public static void main(String[] args) {

        Scanner scanner1 = new Scanner(System.in);

        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner1.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        scanner1.close();

        String str = "Jay,Rudani,23,Male";
        Scanner scanner2 = new Scanner(str).useDelimiter(",");
        String fname = scanner2.next();
        String lname = scanner2.next();
        int age = scanner2.nextInt();
        String gender = scanner2.next();

        System.out.println("first name : " + fname);
        System.out.println("last name : " + lname);
        System.out.println("age : " + age);
        System.out.println("gender : " + gender);
        scanner2.close();

    }
}
