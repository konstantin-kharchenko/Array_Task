package by.kharchenko.arrays.comparator;

import by.kharchenko.arrays.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayID implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {

        if (o1.getId() > o2.getId()) {
            return 1;
        } else if (o1.getId() < o2.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
