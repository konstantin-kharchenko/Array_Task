package by.kharchenko.arrays.service;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;

import java.util.function.Predicate;

public interface ArrayElementsManipulation {
    double mean(CustomArray array);

    void bubbleSort(CustomArray a) throws CustomException;

    void sortedMerge(CustomArray a) throws CustomException;

    void selectionSort(CustomArray a) throws CustomException;

    int minElement(CustomArray array);

    int maxElement(CustomArray array);

    int countPositiveNegative(CustomArray array, Predicate<Integer> predicate);

    int sumOfElement (CustomArray customArray);
}
