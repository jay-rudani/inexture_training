package FileInputOutputStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// FileReader and FileWriter are classes in Java that are used for reading and writing characters from/to files
// they are part of the java.io package
// useful when you want to work with text-based files
// FileReader read data from file one by one characters
// FileWriter can be used to append data to an existing file or create a new file if does not exist
class Example2 {

    static void WriteToFile() {
        String data = "Hello World!\n";
        try (FileWriter writer = new FileWriter("file2.txt")) {
            writer.write(data);
            System.out.println("Data has been written to the file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void ReadFromFile() {
        try (FileReader reader = new FileReader("file2.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriteToFile();
        ReadFromFile();
    }
}
