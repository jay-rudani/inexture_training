package Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class ReadInputFromFile {

    public static void main(String[] args) {
        try {
            File inputFile = new File("file1.txt");
            Scanner scanner = new Scanner(inputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        }
    }
}
