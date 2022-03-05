package by.kharchenko.arrays.util;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomCheck {
    private static final Logger LOGGER = LogManager.getLogger(CustomArray.class);

    public static void nullCheck(Object o) throws CustomException {
        if (o == null) {
            LOGGER.log(Level.ERROR, "null pointer");
            throw new CustomException("null pointer");
        }
    }

    public static boolean isLengthZero(int[] a) {
        return a.length == 0;
    }
}
