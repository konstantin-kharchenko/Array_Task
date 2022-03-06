package by.kharchenko.arrays.manipulation;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdder {

    public static List<CustomArray> addCustomArrayToList(CustomArray... arrays) {
        List<CustomArray> customArrays = new ArrayList<>();
        customArrays.addAll(List.of(arrays));
        return customArrays;
    }

}
