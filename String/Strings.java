package String;

class Strings {

    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = new String("World");
        char[] charArray = new char[] { 'j', 'a', 'y' };
        String str3 = new String(charArray);

        System.out.println(str1 + " " + str2 + " " + str3);
    }
}
