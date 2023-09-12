package CollectionFramework.Sets;

import java.util.LinkedHashSet;
import java.util.Set;

class LinkedHashSetExample {

    public static void main(String[] args) {

        Set<String> strings = new LinkedHashSet<>();
        strings.add("str1");
        strings.add("str2");
        strings.add("str3");
        strings.add("str4");
        strings.add(null);
        System.out.println(strings);
    }
}
