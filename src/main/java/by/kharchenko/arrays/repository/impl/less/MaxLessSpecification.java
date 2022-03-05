package by.kharchenko.arrays.repository.impl.less;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class MaxLessSpecification implements Specification {

    private int max;

    public MaxLessSpecification(int max) {
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        return this.max > Warehouse.getInstance().get(customArray.getId()).getMax();
    }

}
