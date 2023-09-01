package DataInputOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * DataInput/OutputStream classes are used for reading and writing primitive data types and strigs in a machine-
 * independent way. They provide methods for reading and writing various data types.
 * 
 * DataInputStream :
 * allows you to read primitive data types and strings from an underlying input stream.
 * it provides various methods to read data types for int, double, string etc.
 * this data is read in a binary format
 * 
 * DataOutputStream :
 * allows you to write primitive data types and strings to an underlying output stream
 * similarly it provides methods for writing data types in binary format
 */
class Example {

    static void ReadFromFile() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"))) {
            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            String stringValue = dis.readUTF();

            System.out.println("int value : " + intValue);
            System.out.println("double value : " + doubleValue);
            System.out.println("string value : " + stringValue);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    static void WriteToFile() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.dat"))) {
            dos.writeInt(8);
            dos.writeDouble(3.14);
            dos.writeUTF("HELLO WORLD!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // WriteToFile();
        ReadFromFile();
    }
}
