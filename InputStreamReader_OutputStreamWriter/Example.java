package InputStreamReader_OutputStreamWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * InputStreamReader and OutputStreamWriter are classes that provide a way to bridge the gap between
 * byte streams and character streams when working with i/o operations
 * 
 * InputStreamReader :
 * is a class that wraps an InputStream and converts the incoming byte stream into character stream using
 * a specified character encoding.
 * This is particularly useful when reading text data from a source that provides bytes (like from file, network
 * socket, other binary data sources) and you want to work with characters
 * 
 * OutputStreamWriter :
 * is a class that wraps an OutputStream and converts outgoing character stream into byte stream using
 * a specified character encoding.
 * This is useful when you want to write character data to an output destination that requires bytes
 */
class Example {

    static void ReadFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream("file2.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            int readChar;
            while ((readChar = inputStreamReader.read()) != -1) {
                System.out.print((char) readChar);
            }
            inputStreamReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void WriteToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file2.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            String data = "Hello, OutputStreamWriter!";
            outputStreamWriter.write(data);
            outputStreamWriter.close();
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
