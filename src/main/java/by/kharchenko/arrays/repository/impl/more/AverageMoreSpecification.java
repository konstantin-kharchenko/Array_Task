package by.kharchenko.arrays.repository.impl.more;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class AverageMoreSpecification implements Specification {

    private double average;

    public AverageMoreSpecification(double average) {
        this.average = average;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        return this.average < Warehouse.getInstance().get(customArray.getId()).getAverage();
    }
}
