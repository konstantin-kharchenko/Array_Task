package by.kharchenko.arrays.repository.impl.equals;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.repository.Specification;

public class IdEqualsSpecification implements Specification {

    private int id;

    public IdEqualsSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId() == id;
    }

}
