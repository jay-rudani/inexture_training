package String;

class StringMethods {

    public static void main(String[] args) {

        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        String str4 = "world";
        String str5 = "hello";
        String str6 = "hello world";
        String str7 = "    Jay Rudani   ";

        System.out.println("length() : " + str1.length());
        System.out.println("charAt() : " + str2.charAt(3));
        System.out.println("concat() : " + str1.concat(str4));
        System.out.println("equals() : " + str1.equals(str2));
        System.out.println("equals() for new String obj : " + str1.equals(str3));
        System.out.println("equalsIgnoreCase() : " + str1.equalsIgnoreCase(str5));
        System.out.println("compareTo() lexicographically : " + str1.compareTo(str2));
        System.out.println("compareToIgnoreCase() lexicographically : " + str1.compareToIgnoreCase(str5));
        System.out.println("startsWith() : " + str3.startsWith("Hell"));
        System.out.println("endsWith() : " + str3.endsWith("lo"));
        System.out.println("indexOf(ch/str) : " + str4.indexOf('o'));
        System.out.println("indexOf(ch/str, startIndex) : " + str5.indexOf("lo", 2));
        System.out.println("lastIndexOf(ch/str) : " + str6.lastIndexOf('o'));
        System.out.println("lastIndexOf(ch/str, startIndex) : " + str6.lastIndexOf('o', 5));
        System.out.println("substring(startIndex) : " + str6.substring(5));
        System.out.println("substring(startIndex, endIndex) : " + str6.substring(2, 7));
        System.out.println("toLowerCase() : " + str1.toLowerCase());
        System.out.println("toUpperCase() : " + str6.toUpperCase());
        System.out.println("trim() : " + str7.trim());
        System.out.println("replace(old, new) : " + str7.replace('a', 'A').trim());
        System.out.println("replace(oldstr, newstr) : " + str7.replace("Jay", "Yaj").trim());
        System.out.println("split(regex/separator) : " + str6.split(" ")[1]);
        System.out.println("isEmpty() : " + str3.isEmpty());
        System.out.println("contains() : " + str7.contains("Jay"));

    }
}
