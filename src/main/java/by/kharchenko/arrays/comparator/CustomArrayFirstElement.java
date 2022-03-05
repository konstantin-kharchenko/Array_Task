package by.kharchenko.arrays.comparator;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class CustomArrayFirstElement implements Comparator<CustomArray> {

    private static final Logger LOGGER = LogManager.getLogger(CustomArray.class);

    @Override
    public int compare(CustomArray o1, CustomArray o2) {

        try {
            int element1 = o1.getElement(0);
            int element2 = o2.getElement(0);

            if (element1 > element2) {
                return 1;
            } else if (element1 < element2) {
                return -1;
            } else {
                return 0;
            }
        } catch (CustomException e) {
            LOGGER.log(Level.ERROR, e.getMessageName());
        }

        return 0;
    }
}
