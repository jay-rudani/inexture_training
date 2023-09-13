package VersionHistory.Java8;

import java.util.Optional;

class OptionalExample {

    public static void main(String[] args) {
        String[] strs = new String[10];
        Optional<String> checkNull = Optional.ofNullable(strs[5]);
        if (checkNull.isPresent()) {
            System.out.println(strs[5].toLowerCase());
        } else {
            System.out.println("String value is not present");
        }

        strs[5] = "JAVA OPTIONAL CLASS EXAMPLE";
        checkNull = Optional.ofNullable(strs[5]);

        if (checkNull.isPresent()) {
            System.out.println(strs[5].toLowerCase());
        } else {
            System.out.println("String value is not present");
        }
    }
}
