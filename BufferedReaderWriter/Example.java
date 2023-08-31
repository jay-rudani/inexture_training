package BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// BufferedWriter-Reader are classes in java that are used to improve the efficiency of reading and writing data
// buffering capacity means that they read or write data in larger chunks,
// reducing the no. of actual read/write ops and improving overall performance

// BufferReader is used for reading character based input efficiently
// It wraps around a 'Reader' like 'FileReader'/'InputStreamReader' and reads characters
// from the input source in larger chunks, storing them in an internal buffer.
// helps in reducing the overhead of reading data character by character

// BufferWriter is used for writing character-based output efficiently
// It wraps around a 'Writer' like 'FileWriter/OutputStreamWriter' and writes characters to
// the destination in larger chunks
class Example {

    static void WriteToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("file1.txt"))) {
            writer.write("Hello, BufferedWriter!");
            writer.newLine();
            writer.write("Writing data efficiently");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void ReadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("file1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReadFromFile();
        WriteToFile();
        ReadFromFile();
    }
}
