package by.kharchenko.arrays.comparator;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.util.CustomCheck;

import java.util.Comparator;

public class CustomArrayCountElements implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {

        int count1 = o1.getArray().length;
        int count2 = o2.getArray().length;

        if (count1 > count2) {
            return 1;
        } else if (CustomCheck.isLengthZero(o1.getArray()) || count1 < count2) {
            return -1;
        } else {
            return 0;
        }

    }
}
