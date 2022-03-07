package by.kharchenko.arrays.repository.impl.more;

import by.kharchenko.arrays.entity.CustomArray;
import by.kharchenko.arrays.repository.Specification;

public class IdMoreSpecification implements Specification {

    private int id;

    public IdMoreSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray.getId() > id;
    }

}
