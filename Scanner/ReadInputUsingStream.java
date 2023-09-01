package Scanner;

import java.io.InputStream;
import java.util.Scanner;

class ReadInputUsingStream {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        Scanner scanner = new Scanner(inputStream);

        System.out.println("Enter some line of text : (for exit Ctrl+D or Ctrl+Z or Ctrl+C) :");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("You entered : " + line);
        }

        scanner.close();
    }
}
