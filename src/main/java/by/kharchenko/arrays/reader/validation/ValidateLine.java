package by.kharchenko.arrays.reader.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLine {

    private static final String REGEX = "^(\\d+([-,\\s])*)*$";

    public static boolean validate(String line) {

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }
}
