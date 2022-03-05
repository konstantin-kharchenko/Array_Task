package by.kharchenko.arrays.repository;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.exception.CustomException;

public interface Specification {

    boolean specify(CustomArray customArray) throws CustomException;

}
