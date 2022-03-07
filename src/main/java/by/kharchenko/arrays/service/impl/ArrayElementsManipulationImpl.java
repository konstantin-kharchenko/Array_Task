package by.kharchenko.arrays.service.impl;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.service.ArrayElementsManipulation;
import by.kharchenko.arrays.util.CustomCheck;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayElementsManipulationImpl implements ArrayElementsManipulation {

    @Override
    public double mean(CustomArray array) {
        if(CustomCheck.isLengthZero(array.getArray())){
            return 0;
        }
        return Arrays.stream(array.getArray()).average().getAsDouble();
    }

    @Override
    public void bubbleSort(CustomArray a) throws CustomException {
        if(!CustomCheck.isLengthZero(a.getArray())) {
            int n = a.getArray().length;
            int temp;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - i); j++) {
                    if (a.getElement(j - 1) > a.getElement(j)) {
                        temp = a.getElement(j - 1);
                        a.setElement(a.getElement(j), j - 1);
                        a.setElement(temp, j);
                    }
                }
            }
        }
    }

    @Override
    public void sortedMerge(CustomArray a) throws CustomException {
        if(!CustomCheck.isLengthZero(a.getArray())) {
            a.setArray(sortedMerge(a.getArray()));
        }
    }

    @Override
    public void selectionSort(CustomArray a) throws CustomException {
        if(!CustomCheck.isLengthZero(a.getArray())) {
            for (int i = 0; i < a.getArray().length; i++) {
                int possition = i;
                int min = a.getElement(i);
                for (int j = i + 1; j < a.getArray().length; j++) {
                    if (a.getElement(j) < min) {
                        possition = j;
                        min = a.getElement(j);
                    }
                }
                a.setElement(a.getElement(i), possition);
                a.setElement(min, i);
            }
        }
    }

    @Override
    public int minElement(CustomArray array) {
        if(CustomCheck.isLengthZero(array.getArray())){
            return 0;
        }
        return Arrays.stream(array.getArray()).min().getAsInt();
    }

    @Override
    public int maxElement(CustomArray array) {
        if(CustomCheck.isLengthZero(array.getArray())){
            return 0;
        }
        return Arrays.stream(array.getArray()).max().getAsInt();
    }

    @Override
    public int countPositiveNegative(CustomArray array, Predicate<Integer> predicate) {
        if(CustomCheck.isLengthZero(array.getArray())){
            return 0;
        }
        return (int) Arrays.stream(array.getArray()).filter(predicate::test).count();
    }

    @Override
    public int sumOfElement(CustomArray customArray) {
        if(CustomCheck.isLengthZero(customArray.getArray())){
            return 0;
        }
        return Arrays.stream(customArray.getArray()).sum();
    }

    private int[] sortedMerge(int[] a) {
        if (a == null)
            return null;
        if (a.length < 2)
            return a;
        int[] left = new int[a.length / 2];
        int[] right = new int[a.length - a.length / 2];
        System.arraycopy(a, 0, left, 0, a.length / 2);
        System.arraycopy(a, a.length / 2, right, 0, a.length - a.length / 2);
        left = sortedMerge(left);
        right = sortedMerge(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] finish_array = new int[left.length + right.length];
        int n = left.length, m = right.length, i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                finish_array[k] = left[i];
                i++;
                k++;
            } else {
                finish_array[k] = right[j];
                j++;
                k++;
            }
        }
        while (i < n) {
            finish_array[k] = left[i];
            i++;
            k++;
        }
        while (j < m) {
            finish_array[k] = right[j];
            j++;
            k++;
        }
        return finish_array;
    }
}
