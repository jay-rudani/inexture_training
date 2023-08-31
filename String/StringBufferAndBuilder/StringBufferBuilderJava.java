package String.StringBufferAndBuilder;

class StringBufferBuilderJava {

    public static void main(String[] args) {

        StringBuffer str1 = new StringBuffer("Hello");
        System.out.println(str1);

        System.out.println("append() : " + str1.append(" World"));
        System.out.println("insert(int offset, str) : " + str1.insert(11, "!"));
        System.out.println("delete(start, end) : " + str1.delete(0, 6));
        System.out.println("deleteCharAt(index) : " + str1.deleteCharAt(5));
        System.out.println("replace(start, end, str) : " + str1.replace(0, 5, "Hello"));
        str1.append(" World!");
        System.out.println("substring(start, end) : " + str1.substring(6));
        System.out.println("length() : " + str1.length());
        System.out.println("charAt(index) : " + str1.charAt(11));
        str1.setCharAt(11, '?');
        System.out.println(str1);
        System.out.println("reverse() : " + str1.reverse());
        // str1.toString(); // this is used to convert to immutable string
        System.out.println("capacity() : " + str1.capacity());
        str1.ensureCapacity(100);
        System.out.println("after ensuring capacity : " + str1.capacity());
        str1.trimToSize(); // reduce the capacity to current length
        System.out.println("capacity after trimToSize() : " + str1.capacity());

        System.out.println();

        StringBuilder str2 = new StringBuilder("Hello");
        System.out.println(str2);

        System.out.println("append() : " + str2.append(" World"));
        System.out.println("insert(int offset, str) : " + str2.insert(11, "!"));
        System.out.println("delete(start, end) : " + str2.delete(0, 6));
        System.out.println("deleteCharAt(index) : " + str2.deleteCharAt(5));
        System.out.println("replace(start, end, str) : " + str2.replace(0, 5, "Hello"));
        str2.append(" World!");
        System.out.println("substring(start, end) : " + str2.substring(6));
        System.out.println("length() : " + str2.length());
        System.out.println("charAt(index) : " + str2.charAt(11));
        str2.setCharAt(11, '?');
        System.out.println(str2);
        System.out.println("reverse() : " + str2.reverse());
        // str2.toString(); // this is used to convert to immutable string
        System.out.println("capacity() : " + str2.capacity());
        str2.ensureCapacity(100);
        System.out.println("after ensuring capacity : " + str2.capacity());
        str2.trimToSize(); // reduce the capacity to current length
        System.out.println("capacity after trimToSize() : " + str2.capacity());

    }
}
