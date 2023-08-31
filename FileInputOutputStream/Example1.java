package FileInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// FileInputStream & FileOutputStream are part of java.io package
// used to read/write data to files
// often used for handling binary data
// its important to close streams once you are done using them to release system resources
public class Example1 {

    static void ReadFromFile() {
        try {
            FileInputStream inputStream = new FileInputStream("file1.txt");
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void WriteToFile() {
        try {
            FileOutputStream outputStream = new FileOutputStream("file1.txt");
            String text = "Jay Rudani";
            byte[] data = text.getBytes();
            outputStream.write(data);
            outputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriteToFile();
        ReadFromFile();
    }
}
