package by.kharchenko.arrays.repository.impl.less;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class MinLessSpecification implements Specification {

    private int min;

    public MinLessSpecification(int min) {
        this.min = min;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        CustomArrayParameters parameters = Warehouse.getInstance().get(customArray.getId());
        return this.min > parameters.getMin();
    }
}
