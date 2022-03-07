package by.kharchenko.arrays.repository.impl.less;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class AverageLessSpecification implements Specification {

    private double average;

    public AverageLessSpecification(double average) {
        this.average = average;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        return this.average > Warehouse.getInstance().get(customArray.getId()).getAverage();
    }
}
