package by.kharchenko.arrays.repository.impl.less;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.repository.Specification;

public class IdLessSpecification implements Specification {

    private int id;

    public IdLessSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId() < id;
    }

}
