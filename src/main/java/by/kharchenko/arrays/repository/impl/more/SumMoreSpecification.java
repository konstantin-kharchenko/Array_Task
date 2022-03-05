package by.kharchenko.arrays.repository.impl.more;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.entity.CustomArrayParameters;
import by.kharchenko.arrays.entity.Warehouse;
import by.kharchenko.arrays.exception.CustomException;
import by.kharchenko.arrays.repository.Specification;

public class SumMoreSpecification implements Specification {

    private int sum;

    public SumMoreSpecification(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean specify(CustomArray customArray) throws CustomException {
        CustomArrayParameters parameters = Warehouse.getInstance().get(customArray.getId());
        return this.sum < parameters.getSum();
    }
}
