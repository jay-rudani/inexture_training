package VersionHistory.Java8;

import java.util.StringJoiner;

class StringJoinerExample {

    public static void main(String[] args) {

        StringJoiner joinNames = new StringJoiner(", ", "[", "]");
        joinNames.add("Jay");
        joinNames.add("Aman");
        joinNames.add("Ayush");
        joinNames.add("Arjun");
        joinNames.add("Bhavik");

        System.out.println(joinNames);

        StringJoiner otherNames = new StringJoiner(" : ", "{", "}");
        otherNames.add("Raghav");
        otherNames.add("Kashish");
        otherNames.add("Hardik");
        otherNames.add("Jaimin");

        System.out.println(otherNames);

        // exclude prefix, suffix of second joiner object
        StringJoiner merge = joinNames.merge(otherNames);
        System.out.println(merge);

    }
}
