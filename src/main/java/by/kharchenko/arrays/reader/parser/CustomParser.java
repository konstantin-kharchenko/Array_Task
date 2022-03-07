package by.kharchenko.arrays.reader.parser;

import java.util.Objects;

public class CustomParser {

    private static final String REGEX = "[-,!?\\s]";

    public static int[] parse(String line) {
        String[] strArr = line.split(REGEX);
        int[] a;
        if (strArr.length == 1 && Objects.equals(strArr[0], "")) {
            return new int[0];
        } else {
            a = new int[strArr.length];
        }
        for (int i = 0; i < strArr.length; i++) {
            a[i] = Integer.parseInt(strArr[i]);
        }
        return a;
    }
}
