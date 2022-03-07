package by.kharchenko.arrays.repository.impl.equals;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class SumEqualsSpecification implements Specification {

    private int sum;

    public SumEqualsSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        CustomArrayParameters parameters = Warehouse.getInstance().get(customArray.getId());
        return this.sum == parameters.getSum();
    }
}
