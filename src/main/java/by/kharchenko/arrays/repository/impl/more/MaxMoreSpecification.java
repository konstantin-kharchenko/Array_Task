package by.kharchenko.arrays.repository.impl.more;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class MaxMoreSpecification implements Specification {

    private int max;

    public MaxMoreSpecification(int max) {
        this.max = max;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        return this.max < Warehouse.getInstance().get(customArray.getId()).getMax();
    }

}
